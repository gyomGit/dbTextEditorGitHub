/*
 * generated by Xtext 2.15.0
 */
package org.csstudio.xtext.dbtexteditor.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.csstudio.xtext.dbtexteditor.ide.contentassist.antlr.internal.InternalDbTextEditorParser;
import org.csstudio.xtext.dbtexteditor.services.DbTextEditorGrammarAccess;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class DbTextEditorParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(DbTextEditorGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, DbTextEditorGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getRecordAccess().getInfosfieldsAlternatives_7_0(), "rule__Record__InfosfieldsAlternatives_7_0");
			builder.put(grammarAccess.getFieldAccess().getAlternatives_4(), "rule__Field__Alternatives_4");
			builder.put(grammarAccess.getFieldnamesAccess().getAlternatives(), "rule__Fieldnames__Alternatives");
			builder.put(grammarAccess.getRecordnamesAccess().getAlternatives(), "rule__Recordnames__Alternatives");
			builder.put(grammarAccess.getRecordAccess().getGroup(), "rule__Record__Group__0");
			builder.put(grammarAccess.getFieldAccess().getGroup(), "rule__Field__Group__0");
			builder.put(grammarAccess.getInfoAccess().getGroup(), "rule__Info__Group__0");
			builder.put(grammarAccess.getDbModelAccess().getRecordsAssignment(), "rule__DbModel__RecordsAssignment");
			builder.put(grammarAccess.getRecordAccess().getNameAssignment_0(), "rule__Record__NameAssignment_0");
			builder.put(grammarAccess.getRecordAccess().getRecordnameAssignment_2(), "rule__Record__RecordnameAssignment_2");
			builder.put(grammarAccess.getRecordAccess().getRecordLinkAssignment_4(), "rule__Record__RecordLinkAssignment_4");
			builder.put(grammarAccess.getRecordAccess().getInfosfieldsAssignment_7(), "rule__Record__InfosfieldsAssignment_7");
			builder.put(grammarAccess.getFieldAccess().getNameAssignment_0(), "rule__Field__NameAssignment_0");
			builder.put(grammarAccess.getFieldAccess().getFieldnameAssignment_2(), "rule__Field__FieldnameAssignment_2");
			builder.put(grammarAccess.getFieldAccess().getFieldstringAssignment_4_0(), "rule__Field__FieldstringAssignment_4_0");
			builder.put(grammarAccess.getFieldAccess().getFieldintAssignment_4_1(), "rule__Field__FieldintAssignment_4_1");
			builder.put(grammarAccess.getInfoAccess().getNameAssignment_2(), "rule__Info__NameAssignment_2");
			builder.put(grammarAccess.getInfoAccess().getInfoValueAssignment_4(), "rule__Info__InfoValueAssignment_4");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private DbTextEditorGrammarAccess grammarAccess;

	@Override
	protected InternalDbTextEditorParser createParser() {
		InternalDbTextEditorParser result = new InternalDbTextEditorParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public DbTextEditorGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(DbTextEditorGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
