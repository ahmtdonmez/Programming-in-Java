JFLAGS = -g
JC = javac
.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java


Classes = \
	Rectangle.java \
	ReadFile.java \
	SkylineProblem.java \
	UserFace.java \
	main.java 


default: classes


classes: $(Classes:.java=.class)

clean:
	$(RM) *.class
