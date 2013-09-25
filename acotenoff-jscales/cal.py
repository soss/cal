#!/usr/bin/env python
# cal implementation
# by Adam Cotenoff (@acotenoff)
#    Jordan Scales (@jdan)
# 18 September 2013

from datetime import date
from sys import argv

# Takes an array of dates (maybe with spaces)
# and displays a grid
# Each item is either 1 or two characters wide
def makeGrid(arr):
    index = 0
    string = ''
    for item in arr:
        # convert numbers to strings
        item = str(item)
        index += 1

        # "pad" our single-character strings
        if len(str(item)) == 1:
            item = ' ' + item
        string += item + ' '

        # add a new line at the end of the week
        if index % 7 == 0:
            string += '\n'

    return string

def main():
    monthDays = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    monthNames = ['January', 'February', 'March', 'April',
                  'May', 'June', 'July', 'August', 'September',
                  'October', 'November', 'December']
    dayNames = ['Su', 'Mo', 'Tu', 'We', 'Th', 'Fr', 'Sa']

    if len(argv) == 3:
        month = int(argv[1])
        year = int(argv[2])
    else:
        today = date.today()
        month = today.month
        year  = today.year

    # first day of the month
    firstOfMonth = date(year, month, 1)
    dayOfWeek = firstOfMonth.weekday()

    # prepend the numbers array
    spacing = [' '] * ((dayOfWeek + 1) % 7)
    numbers = list(range(1, monthDays[month - 1] + 1))

    # deal with leap years
    if month == 2:
        if year % 400 == 0:
            numbers.append(29)
        elif year % 100 == 0:
            pass
        elif year % 4 == 0:
            numbers.append(29)

    # try and center the header (September 2013) as best as we can
    header = monthNames[month - 1] + ' ' + str(year)
    print ' ' * ((20 - len(header)) / 2) + header

    # print the short day names "Su Mo Tu We Th ..."
    print ' '.join(dayNames)

    # print the dates in a grid
    print makeGrid(spacing + numbers)

if __name__ == "__main__":
    main()
