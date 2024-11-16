# test-automation-framework


First of all apologies as I did not fully complete the task.

This framework was built using serenity BDD.
It gets the list of registrations from the input file using a reg ex that caters for both UK registration formats and outputs them to screen 
I then cycle through each registration opening up https://webuyanycar.com  entering in the registration details.

# Cookie trouble!
The 'Accept all cookies' button which should be straightforward to click and accept was not so much!
This was because I eventually realised there was an overlay that obstructed the button click. 
I disabled the overlay and proceeded onto the site.

# Car search result detail issue
The reading of the vehicle details was not so straightforward as I thought it would be.
I ended up passing the details of the table to map and intended to write to output file /car_details.csv

It works for one cycle of vehicle search but for some reason not the others which was frustrating.

My intention was then to run a diff and compare my output file with the car_output.txt.

I could have simply copied the car_out.txt and put it in the scenario directly to compare, but I thought that went
against the spirit of the task and it would be better to try to compare the files.
That would also provide the flexibility to use other files as well.

# To run the test: 
Use the `mvn clean verify` command.


