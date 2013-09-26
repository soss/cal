String.prototype.repeat = function ( num ) {
	return new Array(num + 1).join(this);
}

function cal (month, year) {
	var COLUMN_LENGTH = 21;

	var int_months = ["January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"]; 
	var currentTime = new Date();
	var leading_spaces_header = 0;
	var leading_spaces_first = 0;
	var padding = " ";
	var test_date = 1;

	month = month+1 || currentTime.getMonth();
	year = year || currentTime.getFullYear();

	var first_date = new Date(year, month, 1);
	var last_date = new Date(year, month-1, 0).getDate();

	leading_spaces_header = Math.floor((COLUMN_LENGTH - (int_months[month].length + year.toString().length))/2);

	leading_spaces_first = ((first_date.getDay())*3)

	console.log("%s%s %s",padding.repeat(leading_spaces_header), int_months[month], year);
	console.log("Su Mo Tu We Th Fr Sa");
	var print_string = "";
	while(test_date <= last_date)
	{	
		if(test_date == 1 )
		{
			print_string += padding.repeat(leading_spaces_first);
		}
		if(test_date < 10)
		{
			print_string += " " + test_date.toString() + " ";
		}
		else
		{
			print_string += test_date.toString() + " ";
		}
		if (print_string.length == 21 || test_date == last_date)
		{
			console.log("%s\n", print_string);
			print_string = "";
		}
		test_date++;
	}
	
}
cal();