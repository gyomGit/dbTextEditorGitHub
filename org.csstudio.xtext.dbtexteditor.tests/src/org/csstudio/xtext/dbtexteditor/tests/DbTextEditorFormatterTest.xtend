package org.csstudio.xtext.dbtexteditor.tests

import org.junit.runner.RunWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.InjectWith
import com.google.inject.Inject
import org.eclipse.xtext.testing.formatter.FormatterTestHelper
import org.junit.Test

@RunWith(XtextRunner)
@InjectWith(DbTextEditorInjectorProvider)

class DbTextEditorFormatterTest {
	
		@Inject extension FormatterTestHelper
	
		@Test
	def void testDbTextEditorFormatter() {
		assertFormatted[
			toBeFormatted = '''
				record(ai,"String"){info(asyn:READBACK, "String")field(DTYP,"String")field(SCAN,1)}
				record(bo,"TEST-S7-COOM"){info(asyn:READBACK, "1")
				field(SXST, "Bad Version")}
			'''
			expectation = '''
				record(ai, "String"){
					info(asyn:READBACK, "String")
					field(DTYP, "String")
					field(SCAN, 1)
				}
				record(bo, "TEST-S7-COOM"){
					info(asyn:READBACK, "1")
					field(SXST, "Bad Version")
				}
			'''
		]
	}	
}