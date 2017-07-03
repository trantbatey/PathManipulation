# PathManipulation
This is a solution to the Fortify Path Manipulation issues.

What it is complaining about is that if you take data from an external source, 
then an attacker can use that source to manipulate your path. Thus, enabling 
the attacker do delete files or otherwise compromise your system.

The suggested remedy to this problem is to use a whitelist of trusted 
directories as valid inputs; and, reject everything else.

This solution is not always viable in a production environment. So, I suggest 
an alternative solution. Parse the input for a whitelist of acceptable 
characters. Reject from the input, any character you don't want in the path. 
It could be either removed or replaced.

Below is an example. This does pass the Fortify review. It is important to 
remember here to return the literal and not the char being checked. Fortify 
keeps track of the parts that came from the original input. If you use any 
of the original input, you may still get the error.
