/**
 * generated by Xtext 2.15.0
 */
package org.csstudio.xtext.dbtexteditor.dbTextEditor.impl;

import org.csstudio.xtext.dbtexteditor.dbTextEditor.DbTextEditorPackage;
import org.csstudio.xtext.dbtexteditor.dbTextEditor.Field;
import org.csstudio.xtext.dbtexteditor.dbTextEditor.Fieldnames;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.FieldImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.FieldImpl#getFieldname <em>Fieldname</em>}</li>
 *   <li>{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.FieldImpl#getFieldstring <em>Fieldstring</em>}</li>
 *   <li>{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.FieldImpl#getFieldint <em>Fieldint</em>}</li>
 *   <li>{@link org.csstudio.xtext.dbtexteditor.dbTextEditor.impl.FieldImpl#getFielddouble <em>Fielddouble</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FieldImpl extends MinimalEObjectImpl.Container implements Field
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getFieldname() <em>Fieldname</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFieldname()
   * @generated
   * @ordered
   */
  protected static final Fieldnames FIELDNAME_EDEFAULT = Fieldnames.NAME;

  /**
   * The cached value of the '{@link #getFieldname() <em>Fieldname</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFieldname()
   * @generated
   * @ordered
   */
  protected Fieldnames fieldname = FIELDNAME_EDEFAULT;

  /**
   * The default value of the '{@link #getFieldstring() <em>Fieldstring</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFieldstring()
   * @generated
   * @ordered
   */
  protected static final String FIELDSTRING_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFieldstring() <em>Fieldstring</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFieldstring()
   * @generated
   * @ordered
   */
  protected String fieldstring = FIELDSTRING_EDEFAULT;

  /**
   * The default value of the '{@link #getFieldint() <em>Fieldint</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFieldint()
   * @generated
   * @ordered
   */
  protected static final int FIELDINT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getFieldint() <em>Fieldint</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFieldint()
   * @generated
   * @ordered
   */
  protected int fieldint = FIELDINT_EDEFAULT;

  /**
   * The default value of the '{@link #getFielddouble() <em>Fielddouble</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFielddouble()
   * @generated
   * @ordered
   */
  protected static final String FIELDDOUBLE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFielddouble() <em>Fielddouble</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFielddouble()
   * @generated
   * @ordered
   */
  protected String fielddouble = FIELDDOUBLE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FieldImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return DbTextEditorPackage.Literals.FIELD;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbTextEditorPackage.FIELD__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Fieldnames getFieldname()
  {
    return fieldname;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFieldname(Fieldnames newFieldname)
  {
    Fieldnames oldFieldname = fieldname;
    fieldname = newFieldname == null ? FIELDNAME_EDEFAULT : newFieldname;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbTextEditorPackage.FIELD__FIELDNAME, oldFieldname, fieldname));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFieldstring()
  {
    return fieldstring;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFieldstring(String newFieldstring)
  {
    String oldFieldstring = fieldstring;
    fieldstring = newFieldstring;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbTextEditorPackage.FIELD__FIELDSTRING, oldFieldstring, fieldstring));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getFieldint()
  {
    return fieldint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFieldint(int newFieldint)
  {
    int oldFieldint = fieldint;
    fieldint = newFieldint;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbTextEditorPackage.FIELD__FIELDINT, oldFieldint, fieldint));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFielddouble()
  {
    return fielddouble;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFielddouble(String newFielddouble)
  {
    String oldFielddouble = fielddouble;
    fielddouble = newFielddouble;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbTextEditorPackage.FIELD__FIELDDOUBLE, oldFielddouble, fielddouble));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case DbTextEditorPackage.FIELD__NAME:
        return getName();
      case DbTextEditorPackage.FIELD__FIELDNAME:
        return getFieldname();
      case DbTextEditorPackage.FIELD__FIELDSTRING:
        return getFieldstring();
      case DbTextEditorPackage.FIELD__FIELDINT:
        return getFieldint();
      case DbTextEditorPackage.FIELD__FIELDDOUBLE:
        return getFielddouble();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case DbTextEditorPackage.FIELD__NAME:
        setName((String)newValue);
        return;
      case DbTextEditorPackage.FIELD__FIELDNAME:
        setFieldname((Fieldnames)newValue);
        return;
      case DbTextEditorPackage.FIELD__FIELDSTRING:
        setFieldstring((String)newValue);
        return;
      case DbTextEditorPackage.FIELD__FIELDINT:
        setFieldint((Integer)newValue);
        return;
      case DbTextEditorPackage.FIELD__FIELDDOUBLE:
        setFielddouble((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case DbTextEditorPackage.FIELD__NAME:
        setName(NAME_EDEFAULT);
        return;
      case DbTextEditorPackage.FIELD__FIELDNAME:
        setFieldname(FIELDNAME_EDEFAULT);
        return;
      case DbTextEditorPackage.FIELD__FIELDSTRING:
        setFieldstring(FIELDSTRING_EDEFAULT);
        return;
      case DbTextEditorPackage.FIELD__FIELDINT:
        setFieldint(FIELDINT_EDEFAULT);
        return;
      case DbTextEditorPackage.FIELD__FIELDDOUBLE:
        setFielddouble(FIELDDOUBLE_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case DbTextEditorPackage.FIELD__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case DbTextEditorPackage.FIELD__FIELDNAME:
        return fieldname != FIELDNAME_EDEFAULT;
      case DbTextEditorPackage.FIELD__FIELDSTRING:
        return FIELDSTRING_EDEFAULT == null ? fieldstring != null : !FIELDSTRING_EDEFAULT.equals(fieldstring);
      case DbTextEditorPackage.FIELD__FIELDINT:
        return fieldint != FIELDINT_EDEFAULT;
      case DbTextEditorPackage.FIELD__FIELDDOUBLE:
        return FIELDDOUBLE_EDEFAULT == null ? fielddouble != null : !FIELDDOUBLE_EDEFAULT.equals(fielddouble);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", fieldname: ");
    result.append(fieldname);
    result.append(", fieldstring: ");
    result.append(fieldstring);
    result.append(", fieldint: ");
    result.append(fieldint);
    result.append(", fielddouble: ");
    result.append(fielddouble);
    result.append(')');
    return result.toString();
  }

} //FieldImpl
