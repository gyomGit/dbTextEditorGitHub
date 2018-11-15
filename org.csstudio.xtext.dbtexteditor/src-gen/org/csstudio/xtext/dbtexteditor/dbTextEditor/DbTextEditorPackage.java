/**
 * generated by Xtext 2.15.0
 */
package org.csstudio.xtext.dbtexteditor.dbTextEditor;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.DbTextEditorFactory
 * @model kind="package"
 * @generated
 */
public interface DbTextEditorPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "dbTextEditor";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.csstudio.org/xtext/dbtexteditor/DbTextEditor";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "dbTextEditor";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DbTextEditorPackage eINSTANCE = org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.DbTextEditorPackageImpl.init();

  /**
   * The meta object id for the '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.dbModelImpl <em>db Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.dbModelImpl
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.DbTextEditorPackageImpl#getdbModel()
   * @generated
   */
  int DB_MODEL = 0;

  /**
   * The feature id for the '<em><b>Records</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_MODEL__RECORDS = 0;

  /**
   * The number of structural features of the '<em>db Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.RecordImpl <em>Record</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.RecordImpl
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.DbTextEditorPackageImpl#getRecord()
   * @generated
   */
  int RECORD = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD__NAME = 0;

  /**
   * The feature id for the '<em><b>Recordname</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD__RECORDNAME = 1;

  /**
   * The feature id for the '<em><b>Record Link</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD__RECORD_LINK = 2;

  /**
   * The feature id for the '<em><b>Infosfields</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD__INFOSFIELDS = 3;

  /**
   * The number of structural features of the '<em>Record</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.FieldImpl <em>Field</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.FieldImpl
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.DbTextEditorPackageImpl#getField()
   * @generated
   */
  int FIELD = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD__NAME = 0;

  /**
   * The feature id for the '<em><b>Fieldname</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD__FIELDNAME = 1;

  /**
   * The feature id for the '<em><b>Fieldstring</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD__FIELDSTRING = 2;

  /**
   * The feature id for the '<em><b>Fieldint</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD__FIELDINT = 3;

  /**
   * The number of structural features of the '<em>Field</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.InfoImpl <em>Info</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.InfoImpl
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.DbTextEditorPackageImpl#getInfo()
   * @generated
   */
  int INFO = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFO__NAME = 0;

  /**
   * The feature id for the '<em><b>Info Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFO__INFO_VALUE = 1;

  /**
   * The number of structural features of the '<em>Info</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFO_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.Fieldnames <em>Fieldnames</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.Fieldnames
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.DbTextEditorPackageImpl#getFieldnames()
   * @generated
   */
  int FIELDNAMES = 4;

  /**
   * The meta object id for the '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.Recordnames <em>Recordnames</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.Recordnames
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.DbTextEditorPackageImpl#getRecordnames()
   * @generated
   */
  int RECORDNAMES = 5;


  /**
   * Returns the meta object for class '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.dbModel <em>db Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>db Model</em>'.
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.dbModel
   * @generated
   */
  EClass getdbModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.dbModel#getRecords <em>Records</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Records</em>'.
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.dbModel#getRecords()
   * @see #getdbModel()
   * @generated
   */
  EReference getdbModel_Records();

  /**
   * Returns the meta object for class '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.Record <em>Record</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Record</em>'.
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.Record
   * @generated
   */
  EClass getRecord();

  /**
   * Returns the meta object for the attribute '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.Record#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.Record#getName()
   * @see #getRecord()
   * @generated
   */
  EAttribute getRecord_Name();

  /**
   * Returns the meta object for the attribute '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.Record#getRecordname <em>Recordname</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Recordname</em>'.
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.Record#getRecordname()
   * @see #getRecord()
   * @generated
   */
  EAttribute getRecord_Recordname();

  /**
   * Returns the meta object for the attribute '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.Record#getRecordLink <em>Record Link</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Record Link</em>'.
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.Record#getRecordLink()
   * @see #getRecord()
   * @generated
   */
  EAttribute getRecord_RecordLink();

  /**
   * Returns the meta object for the containment reference list '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.Record#getInfosfields <em>Infosfields</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Infosfields</em>'.
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.Record#getInfosfields()
   * @see #getRecord()
   * @generated
   */
  EReference getRecord_Infosfields();

  /**
   * Returns the meta object for class '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.Field <em>Field</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Field</em>'.
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.Field
   * @generated
   */
  EClass getField();

  /**
   * Returns the meta object for the attribute '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.Field#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.Field#getName()
   * @see #getField()
   * @generated
   */
  EAttribute getField_Name();

  /**
   * Returns the meta object for the attribute '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.Field#getFieldname <em>Fieldname</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Fieldname</em>'.
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.Field#getFieldname()
   * @see #getField()
   * @generated
   */
  EAttribute getField_Fieldname();

  /**
   * Returns the meta object for the attribute '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.Field#getFieldstring <em>Fieldstring</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Fieldstring</em>'.
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.Field#getFieldstring()
   * @see #getField()
   * @generated
   */
  EAttribute getField_Fieldstring();

  /**
   * Returns the meta object for the attribute '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.Field#getFieldint <em>Fieldint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Fieldint</em>'.
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.Field#getFieldint()
   * @see #getField()
   * @generated
   */
  EAttribute getField_Fieldint();

  /**
   * Returns the meta object for class '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.Info <em>Info</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Info</em>'.
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.Info
   * @generated
   */
  EClass getInfo();

  /**
   * Returns the meta object for the attribute '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.Info#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.Info#getName()
   * @see #getInfo()
   * @generated
   */
  EAttribute getInfo_Name();

  /**
   * Returns the meta object for the attribute '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.Info#getInfoValue <em>Info Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Info Value</em>'.
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.Info#getInfoValue()
   * @see #getInfo()
   * @generated
   */
  EAttribute getInfo_InfoValue();

  /**
   * Returns the meta object for enum '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.Fieldnames <em>Fieldnames</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Fieldnames</em>'.
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.Fieldnames
   * @generated
   */
  EEnum getFieldnames();

  /**
   * Returns the meta object for enum '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.Recordnames <em>Recordnames</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Recordnames</em>'.
   * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.Recordnames
   * @generated
   */
  EEnum getRecordnames();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  DbTextEditorFactory getDbTextEditorFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.dbModelImpl <em>db Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.dbModelImpl
     * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.DbTextEditorPackageImpl#getdbModel()
     * @generated
     */
    EClass DB_MODEL = eINSTANCE.getdbModel();

    /**
     * The meta object literal for the '<em><b>Records</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DB_MODEL__RECORDS = eINSTANCE.getdbModel_Records();

    /**
     * The meta object literal for the '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.RecordImpl <em>Record</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.RecordImpl
     * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.DbTextEditorPackageImpl#getRecord()
     * @generated
     */
    EClass RECORD = eINSTANCE.getRecord();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RECORD__NAME = eINSTANCE.getRecord_Name();

    /**
     * The meta object literal for the '<em><b>Recordname</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RECORD__RECORDNAME = eINSTANCE.getRecord_Recordname();

    /**
     * The meta object literal for the '<em><b>Record Link</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RECORD__RECORD_LINK = eINSTANCE.getRecord_RecordLink();

    /**
     * The meta object literal for the '<em><b>Infosfields</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD__INFOSFIELDS = eINSTANCE.getRecord_Infosfields();

    /**
     * The meta object literal for the '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.FieldImpl <em>Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.FieldImpl
     * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.DbTextEditorPackageImpl#getField()
     * @generated
     */
    EClass FIELD = eINSTANCE.getField();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FIELD__NAME = eINSTANCE.getField_Name();

    /**
     * The meta object literal for the '<em><b>Fieldname</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FIELD__FIELDNAME = eINSTANCE.getField_Fieldname();

    /**
     * The meta object literal for the '<em><b>Fieldstring</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FIELD__FIELDSTRING = eINSTANCE.getField_Fieldstring();

    /**
     * The meta object literal for the '<em><b>Fieldint</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FIELD__FIELDINT = eINSTANCE.getField_Fieldint();

    /**
     * The meta object literal for the '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.InfoImpl <em>Info</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.InfoImpl
     * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.DbTextEditorPackageImpl#getInfo()
     * @generated
     */
    EClass INFO = eINSTANCE.getInfo();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INFO__NAME = eINSTANCE.getInfo_Name();

    /**
     * The meta object literal for the '<em><b>Info Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INFO__INFO_VALUE = eINSTANCE.getInfo_InfoValue();

    /**
     * The meta object literal for the '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.Fieldnames <em>Fieldnames</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.Fieldnames
     * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.DbTextEditorPackageImpl#getFieldnames()
     * @generated
     */
    EEnum FIELDNAMES = eINSTANCE.getFieldnames();

    /**
     * The meta object literal for the '{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.Recordnames <em>Recordnames</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.Recordnames
     * @see org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.DbTextEditorPackageImpl#getRecordnames()
     * @generated
     */
    EEnum RECORDNAMES = eINSTANCE.getRecordnames();

  }

} //DbTextEditorPackage
