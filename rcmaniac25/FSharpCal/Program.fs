open System
open System.Globalization

let buildDate (args : string []) (cul : CultureInfo) =
    match args with
    | time when args |> Seq.length = 2 -> 
        match Int32.TryParse args.[0] with
        | true,m when m > 0 && m <= 12 ->
            match Int32.TryParse args.[1] with
            | true,year when year > 0 && year <= 9999 ->
                try
                    DateTime(year, m, 1)
                with _ -> DateTime.Now
            | _ -> DateTime.Now
        | _ -> DateTime.Now
    | _ -> DateTime.Now

[<EntryPoint>]
let main argv = 
    //Base setup
    let cul = CultureInfo.CurrentCulture
    let now = buildDate argv cul

    //Print month
    let month = cul.DateTimeFormat.GetMonthName(now.Month)
    let year = now.Year.ToString()
    let header = sprintf "%s %s" month year
    let headerOffset = String(' ', ((3 * 7 - 1) / 2) - (header.Length / 2))

    //Build the calendar values
    let weekDayOfMonthEnum = cul.Calendar.GetDayOfWeek(DateTime(now.Year, now.Month, 1))
    let weekDayOfMonth =    Enum.GetValues(typeof<DayOfWeek>)
                            |> Seq.cast<DayOfWeek>
                            |> Seq.findIndex(fun d -> d = weekDayOfMonthEnum)
    let numberOfDays = cul.Calendar.GetDaysInMonth(now.Year, now.Month)

    //Print calendar
    printfn "%s%s" headerOffset header
    
    cul.DateTimeFormat.DayNames
    |> Seq.map(fun d -> if d.Length <= 2 then d else d.Substring(0, 2))
    |> Seq.iter(fun w -> printf "%s " w)

    printf "\n%s" (String(' ', weekDayOfMonth * 3))
    Seq.init numberOfDays (fun i -> (i + 1),((weekDayOfMonth + i) % 7))
    |> Seq.iter(fun (d,w) ->
        let format = String.Format("{0,2}", d)
        let printFun = if w = 6 then printfn else printf
        printFun "%s " format)

    0
