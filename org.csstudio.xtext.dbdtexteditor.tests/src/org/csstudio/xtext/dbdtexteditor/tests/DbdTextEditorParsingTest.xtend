/*
 * generated by Xtext 2.15.0
 */
package org.csstudio.xtext.dbdtexteditor.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.csstudio.xtext.dbdtexteditor.dbdTextEditor.dbdModel
import org.csstudio.xtext.dbdtexteditor.dbdTextEditor.Recordtype
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(DbdTextEditorInjectorProvider)
//@InjectWith(DbdTextEditorInjectorProvider)

class DbdTextEditorParsingTest {
	
//	@Inject ParseHelper<dbdModel> parseHelper
	
	@Inject extension ParseHelper<dbdModel>
	@Inject extension ValidationTestHelper
	
	@Test
	def void testParsing() {
		val dbdModel = '''
			menu(MyMenuType) {
				choice(MyChoiceType, "String")
			}
			recordtype(MyRecordType) {
			field(MyFieldType, DBF_MyDbfType) {
				MyfieldAttribute("String")
				MyfieldAttribute(int)
			}

		'''.parse

//		val entity = dbdModel.recordtype.get(0)
//		Assert.assertEquals("MyEntity", record.name)
//
//		val attribute = recordtype.attributes.get(0)
//		Assert.assertEquals("attribute", attribute.name);
//		Assert.assertEquals("MyEntity", (attribute.type.elementType as Recordtype).record.name);
//	}
//	}
//
//	@Test
//	def void testCorrectParsing() {
//		'''
//			entity MyEntity {
//			    MyEntity attribute;
//			}
//		'''.parse.assertNoErrors
	}
}
