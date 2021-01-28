APP_NAME=RockPaperScissors

SRC_DIR=src
TEST_DIR=test
OUTPUT_DIR=.output

.PHONY: TallyTests

.SUFFIXES = .java .class

VPATH = \
  $(SRC_DIR)/rockpaperscissors \
  $(OUTPUT_DIR/$(SRC_DIR)/rockpaperscissors \
  $(OUTPUT_DIR/$(SRC_DIR)/rockpaperscissors/rockpaperscissors

CPATH=$(PWD)/$(OUTPUT_DIR):$(PWD)/$(OUTPUT_DIR)/rockpaperscissors:$(PWD)/$(OUTPUT_DIR)/terminalgame:$(PWD)/$(OUTPUT_DIR)/terminalgame/ui:$(PWD)/$(OUTPUT_DIR)/terminalgame/platform

#CPATH_BASE_DIR = $(PWD)/$(OUTPUT_DIR)/$(SRC_DIR)
CPATH_BASE_DIR = $(PWD)/$(SRC_DIR)

CPATH = $(CPATH_BASE_DIR):$(CPATH_BASE_DIR)/rockpaperscissors

TEST_CPATHS=.:$(TEST_DIR)/junit-4.13.jar:$(TEST_DIR)/hamcrest-core-1.3.jar:$(TEST_DIR):$(CPATH)

TALLY_SRC := $(shell find $(SRC_DIR)/rockpaperscissors -name '*.java')
TALLY_CLASS := $(subst .java,.class, $(TALLY_SRC))

HandShape.class: HandShape.java
RockShapedHand.class: HandShape.class
PaperShapedHand.class: HandShape.class
ScissorsShapedHand.class: HandShape.class
Rock.class: RockShapedHand.class Rock.java
Paper.class: PaperShapedHand.class Paper.java
Scissors.class: ScissorsShapedHand.class Scissors.java
HandShapes.class: HandShape.class Rock.class Paper.class Scissors.class
Tally.class: Tally.java

$(TALLY_CLASS): %.class: %.java
#	@mkdir -p $(@D)
	@echo "Compiling $<"
	javac $< -Xlint:deprecation -cp $(CPATH)
#	@javac $< -d $(@D) -Xlint:deprecation -cp $(CPATH)

COMPILED_TESTS_TALLY = \
  $(TEST_DIR)/TallyTestInitializedState.class \
  $(TEST_DIR)/TallyTestUpdatedTally.class \
  $(TEST_DIR)/TallyTestInvalidNrOfRounds.class
COMPILED_TESTS = $(COMPILED_TESTS_TALLY)

TallyTests: Tally.class HandShapes.class HandShape.class $(COMPILED_TESTS_TALLY)

$(COMPILED_TESTS): %.class: %.java $(TALLY_SRC)
	@echo "Compiling $<"
	@javac $< -d $(@D) -Xlint:deprecation -cp $(TEST_CPATHS)
	@echo "Running $(basename $(@F))"
	@java -cp $(TEST_CPATHS) org.junit.runner.JUnitCore $(basename $(@F)) >> $(OUTPUT_DIR)/test_log.txt

test: TallyTests

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
