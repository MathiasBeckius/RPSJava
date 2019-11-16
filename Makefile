APP_NAME=RockPaperScissors

SRC_DIR=src
TEST_DIR=test
OUTPUT_DIR=.output

CPATH=$(PWD)/$(OUTPUT_DIR):$(PWD)/$(OUTPUT_DIR)/rockpaperscissors:$(PWD)/$(OUTPUT_DIR)/terminalgame:$(PWD)/$(OUTPUT_DIR)/terminalgame/ui:$(PWD)/$(OUTPUT_DIR)/terminalgame/platform

TEST_CPATHS=.:$(TEST_DIR)/junit-4.12.jar:$(TEST_DIR)/hamcrest-core-1.3.jar:$(TEST_DIR):$(CPATH)

test_runner: rebuild
	@javac -cp $(TEST_CPATHS) $(TEST_DIR)/*.java
	@java -cp $(TEST_CPATHS) org.junit.runner.JUnitCore TallyTestInitializedState
	@java -cp $(TEST_CPATHS) org.junit.runner.JUnitCore TallyTestUpdatedTally
	@java -cp $(TEST_CPATHS) org.junit.runner.JUnitCore TallyTestInvalidNrOfRounds
	@java -cp $(TEST_CPATHS) org.junit.runner.JUnitCore TallyTestUpdateWithNull
	@java -cp $(TEST_CPATHS) org.junit.runner.JUnitCore TallyTestUpdateWithInvalidHandshapes
	@java -cp $(TEST_CPATHS) org.junit.runner.JUnitCore TallyTestUpdateWithInvalidTally

clean:
	@rm -rf $(OUTPUT_DIR)

build:
	@mkdir -p $(OUTPUT_DIR)
	@javac $(SRC_DIR)/rockpaperscissors/*.java -d $(OUTPUT_DIR) -classpath $(CPATH)
	@javac $(SRC_DIR)/terminalgame/ui/*.java -d $(OUTPUT_DIR) -classpath $(CPATH)
	@javac $(SRC_DIR)/terminalgame/*.java -d $(OUTPUT_DIR) -classpath $(CPATH)
	@javac $(SRC_DIR)/terminalgame/ui/platform/*.java -d $(OUTPUT_DIR) -classpath $(CPATH)
	@javac $(SRC_DIR)/*.java -d $(OUTPUT_DIR) -classpath $(CPATH)

rebuild: clean build

run: rebuild
	@java -classpath $(OUTPUT_DIR) $(APP_NAME)
