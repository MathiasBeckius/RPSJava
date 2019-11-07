APP_NAME=RockPaperScissors

clean:
	@rm -f *.class

build:
	@javac $(APP_NAME).java

run: clean build
	@java $(APP_NAME)
