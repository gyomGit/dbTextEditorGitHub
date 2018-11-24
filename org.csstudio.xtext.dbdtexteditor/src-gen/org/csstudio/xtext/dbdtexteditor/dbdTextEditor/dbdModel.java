/**
 * generated by Xtext 2.15.0
 */
package org.csstudio.xtext.dbdtexteditor.dbdTextEditor;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>dbd Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.csstudio.xtext.dbdtexteditor.dbdTextEditor.dbdModel#getMenus <em>Menus</em>}</li>
 *   <li>{@link org.csstudio.xtext.dbdtexteditor.dbdTextEditor.dbdModel#getRecordtypes <em>Recordtypes</em>}</li>
 * </ul>
 *
 * @see org.csstudio.xtext.dbdtexteditor.dbdTextEditor.DbdTextEditorPackage#getdbdModel()
 * @model
 * @generated
 */
public interface dbdModel extends EObject
{
  /**
   * Returns the value of the '<em><b>Menus</b></em>' containment reference list.
   * The list contents are of type {@link org.csstudio.xtext.dbdtexteditor.dbdTextEditor.Menu}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Menus</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Menus</em>' containment reference list.
   * @see org.csstudio.xtext.dbdtexteditor.dbdTextEditor.DbdTextEditorPackage#getdbdModel_Menus()
   * @model containment="true"
   * @generated
   */
  EList<Menu> getMenus();

  /**
   * Returns the value of the '<em><b>Recordtypes</b></em>' containment reference list.
   * The list contents are of type {@link org.csstudio.xtext.dbdtexteditor.dbdTextEditor.Recordtype}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Recordtypes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Recordtypes</em>' containment reference list.
   * @see org.csstudio.xtext.dbdtexteditor.dbdTextEditor.DbdTextEditorPackage#getdbdModel_Recordtypes()
   * @model containment="true"
   * @generated
   */
  EList<Recordtype> getRecordtypes();

} // dbdModel
