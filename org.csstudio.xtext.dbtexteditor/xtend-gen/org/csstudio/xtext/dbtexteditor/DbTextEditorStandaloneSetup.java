/**
 * generated by Xtext 2.15.0
 */
package org.csstudio.xtext.dbtexteditor;

import org.csstudio.xtext.dbtexteditor.DbTextEditorStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class DbTextEditorStandaloneSetup extends DbTextEditorStandaloneSetupGenerated {
  public static void doSetup() {
    new DbTextEditorStandaloneSetup().createInjectorAndDoEMFRegistration();
  }
}
