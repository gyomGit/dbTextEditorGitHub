package org.csstudio.xtext.dbtexteditor.ui.tests

import org.eclipse.xtext.ui.testing.AbstractContentAssistTest
import org.junit.runner.RunWith
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(DbTextEditorUiInjectorProvider))
class DbTextEditorContentAssistTest extends AbstractContentAssistTest {

	@Test
	def void testEmptyProgram() {
		newBuilder.assertText("record")
	}

	@Test
	def void testRecordNames() {
		newBuilder.append("record(").assertText("(", "ai", "ao", "bi", "bo", "calc", "calcout", "longin", "longout",
			"lsi", "lso", "mbbi", "mbbiDirect", "mbbo", "mbboDirect", "scalcout", "stringin", "stringout", "waveform")
	}

	@Test
	def void testFieldNames() {
		newBuilder.append("record(ai, CWS-TCWS-DLHT:MT2-TT){
	info(asyn:READBACK, 4)
	field(").assertText("(", "ASG", "CALC", "DESC", "DRVH", "DRVL", "DTYP", "EGU", "EGUF", "EGUL", "EIST", "EISV",
			"EIVL", "ELST", "ELSV", "ELVL", "FLNK", "FRST", "FRSV", "FRVL", "FVST", "FVSV", "FVVL", "HHSV", "HIGH",
			"HIHI", "HOPR", "HSV", "HYST", "INAA", "INBB", "INCC", "INP", "INPA", "INPB", "INPC", "INPD", "INPE",
			"INPF", "INPG", "INPH", "INPI", "INPJ", "INPK", "LINR", "LLSV", "LOLO", "LOPR", "LOW", "LSV", "MASK",
			"NAME", "NIST", "NISV", "NIVL", "NOBT", "ONAM", "ONST", "ONSV", "ONVL", "OSV", "OUT", "PACT", "PHAS",
			"PINI", "PREC", "PROC", "SCAN", "SDIS", "SEVR", "SHFT", "SIML", "SIOL", "SSCN", "STAT", "SVST", "SVSV",
			"SVVL", "SXST", "SXSV", "SXVL", "TEST", "TESV", "TEVL", "THST", "THSV", "THVL", "TIME", "TSE", "TWST",
			"TWSV", "TWVL", "UNSV", "ZNAM", "ZRST", "ZRSV", "ZRVL", "ZSV")
	}
}
