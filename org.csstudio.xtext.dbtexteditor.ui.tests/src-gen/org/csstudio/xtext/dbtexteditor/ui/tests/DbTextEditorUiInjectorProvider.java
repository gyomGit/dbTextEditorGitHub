/*
 * generated by Xtext 2.15.0
 */
package org.csstudio.xtext.dbtexteditor.ui.tests;

import com.google.inject.Injector;
import org.csstudio.xtext.dbtexteditor.ui.internal.DbtexteditorActivator;
import org.eclipse.xtext.testing.IInjectorProvider;

public class DbTextEditorUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return DbtexteditorActivator.getInstance().getInjector("org.csstudio.xtext.dbtexteditor.DbTextEditor");
	}

}