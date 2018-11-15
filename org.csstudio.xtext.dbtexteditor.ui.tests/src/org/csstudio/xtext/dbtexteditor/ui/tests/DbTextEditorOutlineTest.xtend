package org.csstudio.xtext.dbtexteditor.ui.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractOutlineTest
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(DbTextEditorUiInjectorProvider)
class DbTextEditorOutlineTest extends AbstractOutlineTest {

	override protected getEditorId() {
		"org.csstudio.xtext.dbtexteditor.DbTextEditor"
	}

	@Test
	def void testOutline() {
		'''
			record(ai, "String"){
				info(asyn:READBACK, "String")
				field(DTYP, "String")
				field(SCAN, 1)
			}
			record(bo, "TEST-S7-COOM"){
				info(asyn:READBACK, "1")
				field(SXST, "Bad Version")
			}
		'''.assertAllLabels(
			'''
				record : String
				  info(asyn:READBACK String)
				  field : String
				  field : 1
				record : TEST-S7-COOM
				  info(asyn:READBACK 1)
				  field : Bad Version
			'''
		)
	}
}
