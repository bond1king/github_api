
Prerequisites:
**Requires Maven
**Requires Java8 or higher

**Create a file called ~/.github which has two values:

login=<username>
password=<password>

or a single token:

oauth=<token>



**How to run:
To run this on CLI use:
    mvn compile exec:java -Dexec.args=<username>
