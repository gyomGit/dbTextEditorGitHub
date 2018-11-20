# Db files Editor Eclipse Plug-in
============================

This whole repository contains these 8 projects that together build this Eclipse plug-in.
*"Db files Editor Eclipse Plug-in"*  
This plug-in is designed to edit db text files in Eclipse IDE, among other environments.


====

## org.csstudio.xtext.dbtexteditor.feature
This project contains the description of the feature for this Db files Editor
implementation that can be found in the feature.xml file. Here, you can change
the name of the feature, the vendor, copyright information, and other things.
Eclipse has a form-based editor for features, and we refer to the Eclipse
documentation for the structure of this file.

## org.csstudio.xtext.dbtexteditor.ide
This project contains the components related to the UI that are independent from
Eclipse (this is useful for targeting IntelliJ and web integration).

## org.csstudio.xtext.dbtexteditor.repository
After a Maven build (mvn clean verify) the target folder of this project will
contain a zipped version of the update site and the subdirectory: "repository"
will contain the update site itself. (Before the build this project contains
only the category.xml and the pom.xml files.)

## org.csstudio.xtext.dbtexteditor.target
This contains the target platform definition with all the dependencies to build
and test this Db files Editor.

## org.csstudio.xtext.dbtexteditor:
This is the main project that contains the grammar definition, which is:
DbTextEditor.xtext and all the runtime components that are independent from the
UI. The grammar language is the corner stone of Xtext. It is a domain-specific
language, carefully designed for the description of our Db Syntax for instance.
It is the file to update if changes must be made such as adding a record or a
field name to the lists. To learn and understand this language: [Xtext grammar language documentation](https://www.eclipse.org/Xtext/documentation/301_grammarlanguage.html).


## org.csstudio.xtext.dbtexteditor.tests:
This project contains the JUnit tests that do not depend on any UI.

## org.csstudio.xtext.dbtexteditor.ui.tests:
This project contains the JUnit tests that depend on the Eclipse UI.

## org.csstudio.xtext.dbtexteditor.ui:
This contains the components related to the Eclipse UI (the Eclipse editor and
features related to the Eclipse tooling).

====

## How to built the plug-in

If you installed the Maven binaries in your system, you can run the build from
the command line from the this dbTextEditorGitHub repository.

Click "Clone or download" and "Download Zip" the dbTextEditorGitHub-master
from this repository just run:

mvn clean verify

## How to install it in Eclipse

After this Maven building is done, the target folder of the
org.csstudio.xtext.dbtexteditor.repository project will contain:

A zipped version of the update site.

The subdirectory: "repository" will contain: The update site itself. Just
indicate the path of this update site in The Eclipse Install New Software...
dialog.

You can put the zipped repository on the web as well to offer an offline
installable version of your software. The Eclipse Install New Software... dialog
allows you to also specify a local ZIP file as the repository.

====
