/*
 * generated by Xtext 2.15.0
 */
package org.csstudio.xtext.dbtexteditor.ui.labeling

import com.google.inject.Inject
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider
import org.csstudio.xtext.dbtexteditor.dbTextEditor.Record
import org.csstudio.xtext.dbtexteditor.dbTextEditor.Field
import org.csstudio.xtext.dbtexteditor.dbTextEditor.Info

/**
 * Provides labels for EObjects.
 * 
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider
 */
class DbTextEditorLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	new(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}
	
		def text(Record r){
		'record : ' + r.recordLink
	}
	 	
	 	def text(Info i){
		'info(asyn:READBACK ' + i.infoValue + ')'
	}
	
		def text(Field f){
		'field : ' + if (f.fieldstring === null) 
			 f.fieldint
			else f.fieldstring
	}
	
		def image(Record r) { "Iter.gif" }
		def image(Field f) { "Itergreen.gif"}
		
	// Labels and icons can be computed like this:
	
//	def text(Greeting ele) {
//		'A greeting to ' + ele.name
//	}
//
//	def image(Greeting ele) {
//		'Greeting.gif'
//	}
}
