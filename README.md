## cal

The calendar utility.

### About

`cal` is a command which produces calendars.

    $ cal
       September 2013
    Su Mo Tu We Th Fr Sa
     1  2  3  4  5  6  7
     8  9 10 11 12 13 14
    15 16 17 18 19 20 21
    22 23 24 25 26 27 28
    29 30

`cal` has many options.

    usage: cal [-jy] [[month] year]
       cal [-j] [-m month] [year]
       ncal [-Jjpwy] [-s country_code] [[month] year]
       ncal [-Jeo] [year]

### Mission

Your mission, if you wish to accept it, is to write a *simplified* version of the `cal` command.

To start off, **do not accept any command-line arguments**. Simply display an ASCII calendar of
the current month. Keep it simple, and try to make your output match the correct output displayed
above.

**You may use any language you'd like**, but please don't just `exec(cal)` and print the result!

### Extended

If that's too easy for you, accept two extra options: the month and year.

    $ cal 7 1992
         July 1992
    Su Mo Tu We Th Fr Sa
              1  2  3  4
     5  6  7  8  9 10 11
    12 13 14 15 16 17 18
    19 20 21 22 23 24 25
    26 27 28 29 30 31

### Skills Required

* Date/Time operations
* String formatting
* Modular arithmetic

Good luck! We're all counting on you.

---

by Jordan Scales ([http://jordanscales.com](http://jordanscales.com)). Stevens Open Source Society, Fall 2013.
