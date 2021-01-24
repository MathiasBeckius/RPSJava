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
  $(SRC_DIR)/rockpaperscissors/Rock.java \
  $(SRC_DIR)/rockpaperscissors/Paper.java \
  $(SRC_DIR)/rockpaperscissors/Scissors.java \
  $(SRC_DIR)/rockpaperscissors/HandShapes.java \
  $(SRC_DIR)/rockpaperscissors/ResultOfRound.java \
  $(SRC_DIR)/rockpaperscissors/Tally.java
TALLY_CLASS := $(TALLY_SRC:%=$(OUTPUT_DIR)/%.class)

$(OUTPUT_DIR)/%.java.class: %.java
	@mkdir -p $(@D)
	@echo "Compiling $<"
	@javac $< -d $(@D) -Xlint:deprecation -cp $(CPATH)

COMPILED_TESTS_TALLY = \
  $(TEST_DIR)/TallyTestInitializedState.class \
  $(TEST_DIR)/TallyTestUpdatedTally.class \
  $(TEST_DIR)/TallyTestInvalidNrOfRounds.class \
  $(TEST_DIR)/TallyTestUpdateWithNull.class \
  $(TEST_DIR)/TallyTestUpdateWithInvalidHandshapes.class
COMPILED_TESTS = $(COMPILED_TESTS_TALLY)

$(COMPILED_TESTS): %.class: %.java $(TALLY_SRC)
	@echo "Compiling $<"
	@javac $< -d $(@D) -Xlint:deprecation -cp $(TEST_CPATHS)
	@echo "Running $(basename $(@F))"
	@java -cp $(TEST_CPATHS) org.junit.runner.JUnitCore $(basename $(@F)) >> $(OUTPUT_DIR)/test_log.txt

TallyTests: $(TALLY_CLASS) $(COMPILED_TESTS_TALLY)

PrintTestLog:
	@cat $(OUTPUT_DIR)/test_log.txt

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
