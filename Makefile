APP_NAME=RockPaperScissors

SRC_DIR=src
TEST_DIR=test
OUTPUT_DIR=.output

#.SUFFIXES = .java .class

VPATH = \
  $(SRC_DIR)/rockpaperscissors \
  $(OUTPUT_DIR/$(SRC_DIR)/rockpaperscissors

CPATH=$(PWD)/$(OUTPUT_DIR):$(PWD)/$(OUTPUT_DIR)/rockpaperscissors:$(PWD)/$(OUTPUT_DIR)/terminalgame:$(PWD)/$(OUTPUT_DIR)/terminalgame/ui:$(PWD)/$(OUTPUT_DIR)/terminalgame/platform

CPATH_BASE_DIR = $(PWD)/$(OUTPUT_DIR)/$(SRC_DIR)

CPATH = $(CPATH_BASE_DIR)/rockpaperscissors

TEST_CPATHS=.:$(TEST_DIR)/junit-4.13.jar:$(TEST_DIR)/hamcrest-core-1.3.jar:$(TEST_DIR):$(CPATH)

TALLY_SRC = \
  $(SRC_DIR)/rockpaperscissors/HandShape.java \
  $(SRC_DIR)/rockpaperscissors/ComparableHandShape.java \
  $(SRC_DIR)/rockpaperscissors/ResultOfRound.java \
  $(SRC_DIR)/rockpaperscissors/Tally.java
TALLY_CLASS := $(TALLY_SRC:%=$(OUTPUT_DIR)/%.class)

$(OUTPUT_DIR)/%.java.class: %.java
	@mkdir -p $(@D)
	@echo "Compiling $<"
	@javac $< -d $(@D) -Xlint:deprecation -cp $(CPATH)

TESTS = $(TEST_DIR)/TallyTestInitializedState.class

$(TESTS): %.class: %.java
	@echo "Compiling $<"
	@javac $< -d $(@D) -Xlint:deprecation -cp $(TEST_CPATHS)

TallyTestInitializedState: $(TALLY_CLASS) $(TEST_DIR)/TallyTestInitializedState.class
	@echo "Running $@"
	@java -cp $(TEST_CPATHS) org.junit.runner.JUnitCore $@

unit_tests: TallyTestInitializedState

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

_create_dirs:
	@mkdir -p $(OUTPUT_DIR)

build: _create_dirs
	@echo "Compiling app..."
	@javac $(SRC_DIR)/rockpaperscissors/*.java -d $(OUTPUT_DIR) -classpath $(CPATH)
	@javac $(SRC_DIR)/terminalgame/ui/*.java -d $(OUTPUT_DIR) -classpath $(CPATH)
	@javac $(SRC_DIR)/terminalgame/*.java -d $(OUTPUT_DIR) -classpath $(CPATH)
	@javac $(SRC_DIR)/terminalgame/ui/platform/*.java -d $(OUTPUT_DIR) -classpath $(CPATH)
	@javac $(SRC_DIR)/*.java -d $(OUTPUT_DIR) -classpath $(CPATH)

rebuild: clean build

run: rebuild
	@java -classpath $(OUTPUT_DIR) $(APP_NAME)
