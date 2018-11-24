package org.csstudio.xtext.dbtexteditor.ui.tests;

import org.csstudio.xtext.dbtexteditor.ui.tests.DbTextEditorUiInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(DbTextEditorUiInjectorProvider.class)
@SuppressWarnings("all")
public class DbTextEditorContentAssistTest extends AbstractContentAssistTest {
  @Test
  public void testEmptyProgram() {
    try {
      this.newBuilder().assertText("record");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRecordNames() {
    try {
      this.newBuilder().append("record(").assertText("(", "ai", "ao", "bi", "bo", "calc", "calcout", "longin", "longout", 
        "lsi", "lso", "mbbi", "mbbiDirect", "mbbo", "mbboDirect", "scalcout", "stringin", "stringout", "waveform");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFieldNames() {
    try {
      this.newBuilder().append("record(ai, CWS-TCWS-DLHT:MT2-TT){\n\tinfo(asyn:READBACK, 4)\n\tfield(").assertText("(", "ASG", "CALC", "DESC", "DRVH", "DRVL", "DTYP", "EGU", "EGUF", "EGUL", "EIST", "EISV", 
        "EIVL", "ELST", "ELSV", "ELVL", "FLNK", "FRST", "FRSV", "FRVL", "FVST", "FVSV", "FVVL", "HHSV", "HIGH", 
        "HIHI", "HOPR", "HSV", "HYST", "INAA", "INBB", "INCC", "INP", "INPA", "INPB", "INPC", "INPD", "INPE", 
        "INPF", "INPG", "INPH", "INPI", "INPJ", "INPK", "LINR", "LLSV", "LOLO", "LOPR", "LOW", "LSV", "MASK", 
        "NAME", "NIST", "NISV", "NIVL", "NOBT", "ONAM", "ONST", "ONSV", "ONVL", "OSV", "OUT", "PACT", "PHAS", 
        "PINI", "PREC", "PROC", "SCAN", "SDIS", "SEVR", "SHFT", "SIML", "SIOL", "SSCN", "STAT", "SVST", "SVSV", 
        "SVVL", "SXST", "SXSV", "SXVL", "TEST", "TESV", "TEVL", "THST", "THSV", "THVL", "TIME", "TSE", "TWST", 
        "TWSV", "TWVL", "UNSV", "ZNAM", "ZRST", "ZRSV", "ZRVL", "ZSV");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
