/**
 * generated by Xtext 2.15.0
 */
package org.csstudio.xtext.dbtexteditor.dbTextEditor;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.Info#getName <em>Name</em>}</li>
 *   <li>{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.Info#getInfoValue <em>Info Value</em>}</li>
 * </ul>
 *
 * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.DbTextEditorPackage#getInfo()
 * @model
 * @generated
 */
public interface Info extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.DbTextEditorPackage#getInfo_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.Info#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Info Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Info Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Info Value</em>' attribute.
   * @see #setInfoValue(String)
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.DbTextEditorPackage#getInfo_InfoValue()
   * @model
   * @generated
   */
  String getInfoValue();

  /**
   * Sets the value of the '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.Info#getInfoValue <em>Info Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Info Value</em>' attribute.
   * @see #getInfoValue()
   * @generated
   */
  void setInfoValue(String value);

} // Info
