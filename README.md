# DbTextEditor Continuous Integration
============================

This whole repository originally called **org.csstudio.xtext.dbtexteditor.parent**
was created within Eclipse Xtext project wizard from the Xtext SDK.
This whole repository contains these 8 projects shown above, which can be updated
and developed with Xtext SDK in Eclipse. Once a modification is made, they can all
together build this Eclipse plug-in with Maven/Tycho, as often as necessary.
This plug-in final product is designed to edit Epics db (database) record files
in Eclipse IDE, among other environments. If you wish to download and install in your Eclipse an
already built version of this product the link is here:
[Epics-record-db-Plugin-for-Eclipse](https://github.com/gyomGit/Epics-record-db-Plugin-for-Eclipse).

====

## These 8 projects are:

### org.csstudio.xtext.dbtexteditor.feature:
This project contains the description of the feature for this Db files Editor
implementation that can be found in the **feature.xml** file. Here, you can change
the name of the feature, the vendor, copyright information, and other things.
Eclipse has a form-based editor for features, and we refer to the Eclipse
documentation for the structure of this file.

### org.csstudio.xtext.dbtexteditor.ide:
This project contains the components related to the UI that are independent from
Eclipse (this is useful for targeting IntelliJ and web integration).

### org.csstudio.xtext.dbtexteditor.repository:
After a Maven build **mvn clean verify** the target folder of this project will
contain a zipped version of the update site and the subdirectory: "repository"
will contain the update site itself. (Before the build this project contains
only the category.xml and the pom.xml files.)

### org.csstudio.xtext.dbtexteditor.target:
This contains the target platform definition with all the dependencies to build
and test this Db files Editor.

### org.csstudio.xtext.dbtexteditor:
This is the main project that contains the grammar definition, which is:
**DbTextEditor.xtext** and all the runtime components that are independent from the
UI. The grammar language is the corner stone of Xtext. It is a domain-specific
language, carefully designed for the description of our Db Syntax for instance.
It is the file to update if changes must be made such as adding a record or a
field name to the lists. To learn and understand this language: [Xtext grammar language documentation](https://www.eclipse.org/Xtext/documentation/301_grammarlanguage.html).
If any change is made, don't forget to go and have a look to the related test projects
to either update them accordingly or simply disable them. If any change is made in
the grammar file **DbTextEditor.xtext** right click on it and run the **mwe2**
(Modeling workflow engine 2). During the MWE2 workflow execution, Xtext will generate
artifacts related to the UI editor for Db syntax, but most important of all, it will
derive an ANTLR specification from the Xtext grammar with all the actions to create
the AST while parsing. The classes for the nodes of the AST will be generated using
the EMF framework. The generator must be run after every modification to the grammar.

### org.csstudio.xtext.dbtexteditor.tests:
This project contains the JUnit tests that do not depend on any UI.

### org.csstudio.xtext.dbtexteditor.ui.tests:
This project contains the JUnit tests that depend on the Eclipse UI.

### org.csstudio.xtext.dbtexteditor.ui:
This project contains the components related to the Eclipse UI (the Eclipse editor and
features related to the Eclipse tooling). A directory shipped in this project is
called **Templates** and it contains templates some users created within Eclipse according to a
context in the Db files that are part of the content assist window list triggered by
pressing *Ctrl + Space*. If you want to keep these templates shipped with the plug-in,
don't forget to first export them all from Eclipse | Preferences | DdTextEditor | Templates and
then place the exported **templates.xml** file in this **Templates** directory.

====

## How to obtain this Db files Editor Plug-in from this dbTextEditorGitHub Github repository:

Click "Clone or download" and "Download Zip" the **dbTextEditorGitHub-master**. You
can rename it as it was called originally: **org.csstudio.xtext.dbtexteditor.parent**.

## How to develop this plug-in:

First, Download and install Xtext SDK in Eclipse IDE. Then import this whole
repository **dbTextEditorGitHub-master** in the package explorer. You can rename it as it was called originally:
**org.csstudio.xtext.dbtexteditor.parent**. Finally, when opening the repository a dialog box will ask you if
you want to convert this *<project name>* project to an Xtext project, press **yes**. You can know start to work on it.
I strongly recommend to get the Bettini, Lorenzo's book: Implementing Domain-Specific Languages with Xtext
and Xtend - [Second Edition](https://www.amazon.com/Implementing-Domain-Specific-Languages-Xtext/dp/1786464969)
or newer to guide you step-by-step to develop this Db files Editor Plug-in.

## How to Build this plug-in with Maven:
*Developed on MacOS with Eclipse Photon and tested on Linux Mint, with Eclipse “2018-11”*

There are two ways:

### First way, with Maven build from any operating system:

Install [Maven binaries](https://maven.apache.org/) in your operating system.

Run the build from the command line from the **dbTextEditorGitHub-master
repository**.

```bash
mvn clean verify
```
### Second way, with Maven build from within Eclipse:

This way you do not need to install Maven on your computer.
Install [M2Eclipse](https://www.eclipse.org/m2e/) abbreviated as m2e, a set of
Eclipse plug-ins that integrate Maven into Eclipse. After imported the
**dbTextEditorGitHub-master** as a project, right-click on the
**dbTextEditorGitHub-master** in the package explorer and select Run As | Maven build…
and in the appearing dialog specify **clean verify** as the goals.
The goal **clean** will instruct Maven to perform a clean build, thus, all the
existing generated artifacts will be removed before building, for example, all
Java class files will be removed before compiling. The goal **verify** will instruct
Maven to compile everything, generate artifacts, for example jar files and
update sites, and run all the tests.

## How to install Db files Editor Plug-in in Eclipse:

After the Maven build, the target folder of the **org.csstudio.xtext.dbtexteditor.repository** project
contains:

### The update site (p2 repository)
The subdirectory called **repository** is the update site itself.
Just indicate the path of this **repository** update site in The Eclipse Install
New Software... dialog.

### A zipped version of the update site (p2 repository)
**org.csstudio.xtext.dbtexteditor.repository-1.0.0-SNAPSHOT.zip** You can put the
zipped repository on the web as well to offer an offline (download first) installable version of
your software. The Eclipse **Install New Software...** dialog allows you to also
specify a local ZIP file as the repository.

## How to open and edit an Epics record file with this Db files Editor Plug-in in eclipse:
Create a project, create any **file_name.db** file, actually any name with the extension **.db**.
A dialog box will ask you if you want to convert this *<project_name>* project to an Xtext project.
Press **yes**. You can now start to edit your **file_name.db** file using this Db files Editor Plug-in.

====

# Acknowledgments
I am grateful to the ITER Organization and more especially to Nadine Utzel who technically supported me, and to my supervisor Bruno Evrard, who initiated this plug-in project and trusted me. Also thanks to Ralph Lange who I was very happy to meet and work with.  Many thanks to Lorenzo Bettini and his book: Implementing Domain-Specific Languages with Xtext and Xtend - Second Edition, which enabled me to create this job. Finally a big thank you to Sven Efftinge, the founder of Xtext.

Guillaume Balourdet
