The first problem in this intro project was simply to return seventeen. I accomplished this with the statement return 17; For the second project in our
intro project we were asked to return the logical and of three booleans: a, b, and c. I did this using the built in && operator in Java. The third 
problem asked us to print out a left justified pyramid of stars with a given number(n) of rows. I accomplished this using a nested for loop. One for 
loop looped through each of the rows, and the other for loop added on stars to the string based off which row it was currently on. In between for loops
I added a new line character and this was returned after the nested for loops finished running. The final problem asked us to find the minimum number
of two and five cent coins that could go into a given number of cents. I did this by first finding the maximum number of 5 cent coins that could
go into the number, then checking if the remainder was divisible by two. If this didn't work then I tried decreasing the number of 5 cent coins by one
and checking if that worked. If both didn't work then I returned -1, otherwise I returned the minimum number of two and five cent coins that could go
into the given number of cents.