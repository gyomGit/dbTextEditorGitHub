/*
 * generated by Xtext 2.15.0
 */
package org.csstudio.xtext.dbtexteditor.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class DbTextEditorAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("org/csstudio/xtext/dbtexteditor/parser/antlr/internal/InternalDbTextEditor.tokens");
	}
}
