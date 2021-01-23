APP_NAME=RockPaperScissors

SRC_DIR=src
TEST_DIR=test
OUTPUT_DIR=.output

CPATH=$(PWD)/$(OUTPUT_DIR):$(PWD)/$(OUTPUT_DIR)/rockpaperscissors:$(PWD)/$(OUTPUT_DIR)/terminalgame:$(PWD)/$(OUTPUT_DIR)/terminalgame/ui:$(PWD)/$(OUTPUT_DIR)/terminalgame/platform

TEST_CPATHS=.:$(TEST_DIR)/junit-4.13.jar:$(TEST_DIR)/hamcrest-core-1.3.jar:$(TEST_DIR):$(CPATH)

test_runner: rebuild
	@echo "Compiling tests..."
	@javac -cp $(TEST_CPATHS) $(TEST_DIR)/*.java -Xlint:deprecation
	@echo "Running tests..."
	@java -cp $(TEST_CPATHS) org.junit.runner.JUnitCore TallyTestInitializedState > /dev/null
	@java -cp $(TEST_CPATHS) org.junit.runner.JUnitCore TallyTestUpdatedTally > /dev/null
	@java -cp $(TEST_CPATHS) org.junit.runner.JUnitCore TallyTestInvalidNrOfRounds > /dev/null
	@java -cp $(TEST_CPATHS) org.junit.runner.JUnitCore TallyTestUpdateWithNull > /dev/null
	@java -cp $(TEST_CPATHS) org.junit.runner.JUnitCore TallyTestUpdateWithInvalidHandshapes > /dev/null
	@echo "Tests were successfully executed!"

clean:
	@echo "Removing artefacts..."
	@rm -rf $(OUTPUT_DIR) $(TEST_DIR)/*.class

build:
	@echo "Compiling app..."
	@mkdir -p $(OUTPUT_DIR)
	@javac $(SRC_DIR)/rockpaperscissors/*.java -d $(OUTPUT_DIR) -classpath $(CPATH)
	@javac $(SRC_DIR)/terminalgame/ui/*.java -d $(OUTPUT_DIR) -classpath $(CPATH)
	@javac $(SRC_DIR)/terminalgame/*.java -d $(OUTPUT_DIR) -classpath $(CPATH)
	@javac $(SRC_DIR)/terminalgame/ui/platform/*.java -d $(OUTPUT_DIR) -classpath $(CPATH)
	@javac $(SRC_DIR)/*.java -d $(OUTPUT_DIR) -classpath $(CPATH)

rebuild: clean build

run: rebuild
	@java -classpath $(OUTPUT_DIR) $(APP_NAME)
