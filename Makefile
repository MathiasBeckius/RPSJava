APP_NAME=RockPaperScissors

SRC_DIR=src
OUTPUT_DIR=.output

CPATH=$(PWD)/$(OUTPUT_DIR):$(PWD)/$(OUTPUT_DIR)/rockpaperscissors:$(PWD)/$(OUTPUT_DIR)/terminalgame:$(PWD)/$(OUTPUT_DIR)/terminalgame/ui:$(PWD)/$(OUTPUT_DIR)/terminalgame/platform

clean:
	@rm -rf $(OUTPUT_DIR)

build:
	@mkdir -p $(OUTPUT_DIR)
	@javac $(SRC_DIR)/rockpaperscissors/*.java -d $(OUTPUT_DIR) -classpath $(CPATH)
	@javac $(SRC_DIR)/terminalgame/ui/*.java -d $(OUTPUT_DIR) -classpath $(CPATH)
	@javac $(SRC_DIR)/terminalgame/*.java -d $(OUTPUT_DIR) -classpath $(CPATH)
	@javac $(SRC_DIR)/terminalgame/platform/*.java -d $(OUTPUT_DIR) -classpath $(CPATH)
	@javac $(SRC_DIR)/*.java -d $(OUTPUT_DIR) -classpath $(CPATH)

rebuild: clean build

run: rebuild
	@java -classpath $(OUTPUT_DIR) $(APP_NAME)
