/*
 * generated by Xtext 2.15.0
 */
package org.csstudio.xtext.dbtexteditor.ide

import com.google.inject.Guice
import org.csstudio.xtext.dbtexteditor.DbTextEditorRuntimeModule
import org.csstudio.xtext.dbtexteditor.DbTextEditorStandaloneSetup
import org.eclipse.xtext.util.Modules2

/**
 * Initialization support for running Xtext languages as language servers.
 */
class DbTextEditorIdeSetup extends DbTextEditorStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new DbTextEditorRuntimeModule, new DbTextEditorIdeModule))
	}
	
}
