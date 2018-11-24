package org.csstudio.xtext.dbtexteditor.tests;

import com.google.inject.Inject;
import org.csstudio.xtext.dbtexteditor.tests.DbTextEditorInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.formatter.FormatterTestHelper;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(DbTextEditorInjectorProvider.class)
@SuppressWarnings("all")
public class DbTextEditorFormatterTest {
  @Inject
  @Extension
  private FormatterTestHelper _formatterTestHelper;
  
  @Test
  public void testDbTextEditorFormatter() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("record(ai,\"String\"){info(asyn:READBACK, \"String\")field(DTYP,\"String\")field(SCAN,1)}");
      _builder.newLine();
      _builder.append("record(bo,\"TEST-S7-COOM\"){info(asyn:READBACK, \"1\")");
      _builder.newLine();
      _builder.append("field(SXST, \"Bad Version\")}");
      _builder.newLine();
      it.setToBeFormatted(_builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("record(ai, \"String\"){");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("info(asyn:READBACK, \"String\")");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("field(DTYP, \"String\")");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("field(SCAN, 1)");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("record(bo, \"TEST-S7-COOM\"){");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("info(asyn:READBACK, \"1\")");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("field(SXST, \"Bad Version\")");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      it.setExpectation(_builder_1);
    };
    this._formatterTestHelper.assertFormatted(_function);
  }
}
