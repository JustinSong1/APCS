#Flag Project
This goal of this flag project was to create a resizable flag using JPanel and JFrame. The way the code is organized is three main classes, flag, main, and star. The flag class is a JPanel which creates the stripes and the stars. The star class inherits from polygon and is what does the math for drawing the stars. The main class creates a JFrame, adds the flag JPanel to the JFrame and sets it to visible. This also contains an action listener for checking if the panel is resized, if it is then it redraws the flag with the new proportions. One major challenge that I had while designing the flag was how to draw the stars because there isn't a built in function in java. Some resources that I used were Mr. Kuszmaul who explained during class how we were supposed to draw the stars in java using math and also the flag specs from [this website.](http://www.usflag.org/flag.specs.html)