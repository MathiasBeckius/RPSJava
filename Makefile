APP_NAME=RockPaperScissors

SRC_DIR=src
OUTPUT_DIR=.output

clean:
	@rm -rf $(OUTPUT_DIR)

build:
	@mkdir -p $(OUTPUT_DIR)
	@javac $(SRC_DIR)/*.java -d $(OUTPUT_DIR)

run: clean build
	@java -classpath $(OUTPUT_DIR) $(APP_NAME)
