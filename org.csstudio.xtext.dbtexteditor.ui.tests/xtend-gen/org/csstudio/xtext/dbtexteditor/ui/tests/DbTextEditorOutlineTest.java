package org.csstudio.xtext.dbtexteditor.ui.tests;

import org.csstudio.xtext.dbtexteditor.ui.tests.DbTextEditorUiInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractOutlineTest;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(DbTextEditorUiInjectorProvider.class)
@SuppressWarnings("all")
public class DbTextEditorOutlineTest extends AbstractOutlineTest {
  @Override
  protected String getEditorId() {
    return "org.csstudio.xtext.dbtexteditor.DbTextEditor";
  }
  
  @Test
  public void testOutline() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("record(ai, \"String\"){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("info(asyn:READBACK, \"String\")");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("field(DTYP, \"String\")");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("field(SCAN, 1)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("record(bo, \"TEST-S7-COOM\"){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("info(asyn:READBACK, \"1\")");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("field(SXST, \"Bad Version\")");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("record : String");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("info(asyn:READBACK String)");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("field : String");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("field : 1");
      _builder_1.newLine();
      _builder_1.append("record : TEST-S7-COOM");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("info(asyn:READBACK 1)");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("field : Bad Version");
      _builder_1.newLine();
      this.assertAllLabels(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
