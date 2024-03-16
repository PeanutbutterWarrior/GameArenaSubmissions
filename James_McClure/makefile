BUILD_DIR = build

$(BUILD_DIR) :
	mkdir $(BUILD_DIR)

$(BUILD_DIR)/%.class : %.java | $(BUILD_DIR)
	javac -d $(BUILD_DIR) $<

all : $(BUILD_DIR)/SpaceInvaders.class $(BUILD_DIR)/*.class | $(BUILD_DIR)

run : all
	java -cp $(BUILD_DIR) SpaceInvaders

clean :
	rm -r $(BUILD_DIR)