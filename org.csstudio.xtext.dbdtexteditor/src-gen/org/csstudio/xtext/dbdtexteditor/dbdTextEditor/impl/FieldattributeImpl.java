/**
 * generated by Xtext 2.15.0
 */
package org.csstudio.xtext.dbdtexteditor.dbdTextEditor.impl;

import org.csstudio.xtext.dbdtexteditor.dbdTextEditor.DbdTextEditorPackage;
import org.csstudio.xtext.dbdtexteditor.dbdTextEditor.Fieldattribute;
import org.csstudio.xtext.dbdtexteditor.dbdTextEditor.Fieldattributenames;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fieldattribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.csstudio.xtext.dbdtexteditor.dbdTextEditor.impl.FieldattributeImpl#getFieldattribute <em>Fieldattribute</em>}</li>
 *   <li>{@link org.csstudio.xtext.dbdtexteditor.dbdTextEditor.impl.FieldattributeImpl#getFieldattributestring <em>Fieldattributestring</em>}</li>
 *   <li>{@link org.csstudio.xtext.dbdtexteditor.dbdTextEditor.impl.FieldattributeImpl#getFieldattributeint <em>Fieldattributeint</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FieldattributeImpl extends MinimalEObjectImpl.Container implements Fieldattribute
{
  /**
   * The default value of the '{@link #getFieldattribute() <em>Fieldattribute</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFieldattribute()
   * @generated
   * @ordered
   */
  protected static final Fieldattributenames FIELDATTRIBUTE_EDEFAULT = Fieldattributenames.SIZE;

  /**
   * The cached value of the '{@link #getFieldattribute() <em>Fieldattribute</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFieldattribute()
   * @generated
   * @ordered
   */
  protected Fieldattributenames fieldattribute = FIELDATTRIBUTE_EDEFAULT;

  /**
   * The default value of the '{@link #getFieldattributestring() <em>Fieldattributestring</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFieldattributestring()
   * @generated
   * @ordered
   */
  protected static final String FIELDATTRIBUTESTRING_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFieldattributestring() <em>Fieldattributestring</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFieldattributestring()
   * @generated
   * @ordered
   */
  protected String fieldattributestring = FIELDATTRIBUTESTRING_EDEFAULT;

  /**
   * The default value of the '{@link #getFieldattributeint() <em>Fieldattributeint</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFieldattributeint()
   * @generated
   * @ordered
   */
  protected static final int FIELDATTRIBUTEINT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getFieldattributeint() <em>Fieldattributeint</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFieldattributeint()
   * @generated
   * @ordered
   */
  protected int fieldattributeint = FIELDATTRIBUTEINT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FieldattributeImpl()
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
    return DbdTextEditorPackage.Literals.FIELDATTRIBUTE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Fieldattributenames getFieldattribute()
  {
    return fieldattribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFieldattribute(Fieldattributenames newFieldattribute)
  {
    Fieldattributenames oldFieldattribute = fieldattribute;
    fieldattribute = newFieldattribute == null ? FIELDATTRIBUTE_EDEFAULT : newFieldattribute;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbdTextEditorPackage.FIELDATTRIBUTE__FIELDATTRIBUTE, oldFieldattribute, fieldattribute));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFieldattributestring()
  {
    return fieldattributestring;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFieldattributestring(String newFieldattributestring)
  {
    String oldFieldattributestring = fieldattributestring;
    fieldattributestring = newFieldattributestring;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbdTextEditorPackage.FIELDATTRIBUTE__FIELDATTRIBUTESTRING, oldFieldattributestring, fieldattributestring));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getFieldattributeint()
  {
    return fieldattributeint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFieldattributeint(int newFieldattributeint)
  {
    int oldFieldattributeint = fieldattributeint;
    fieldattributeint = newFieldattributeint;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbdTextEditorPackage.FIELDATTRIBUTE__FIELDATTRIBUTEINT, oldFieldattributeint, fieldattributeint));
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
      case DbdTextEditorPackage.FIELDATTRIBUTE__FIELDATTRIBUTE:
        return getFieldattribute();
      case DbdTextEditorPackage.FIELDATTRIBUTE__FIELDATTRIBUTESTRING:
        return getFieldattributestring();
      case DbdTextEditorPackage.FIELDATTRIBUTE__FIELDATTRIBUTEINT:
        return getFieldattributeint();
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
      case DbdTextEditorPackage.FIELDATTRIBUTE__FIELDATTRIBUTE:
        setFieldattribute((Fieldattributenames)newValue);
        return;
      case DbdTextEditorPackage.FIELDATTRIBUTE__FIELDATTRIBUTESTRING:
        setFieldattributestring((String)newValue);
        return;
      case DbdTextEditorPackage.FIELDATTRIBUTE__FIELDATTRIBUTEINT:
        setFieldattributeint((Integer)newValue);
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
      case DbdTextEditorPackage.FIELDATTRIBUTE__FIELDATTRIBUTE:
        setFieldattribute(FIELDATTRIBUTE_EDEFAULT);
        return;
      case DbdTextEditorPackage.FIELDATTRIBUTE__FIELDATTRIBUTESTRING:
        setFieldattributestring(FIELDATTRIBUTESTRING_EDEFAULT);
        return;
      case DbdTextEditorPackage.FIELDATTRIBUTE__FIELDATTRIBUTEINT:
        setFieldattributeint(FIELDATTRIBUTEINT_EDEFAULT);
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
      case DbdTextEditorPackage.FIELDATTRIBUTE__FIELDATTRIBUTE:
        return fieldattribute != FIELDATTRIBUTE_EDEFAULT;
      case DbdTextEditorPackage.FIELDATTRIBUTE__FIELDATTRIBUTESTRING:
        return FIELDATTRIBUTESTRING_EDEFAULT == null ? fieldattributestring != null : !FIELDATTRIBUTESTRING_EDEFAULT.equals(fieldattributestring);
      case DbdTextEditorPackage.FIELDATTRIBUTE__FIELDATTRIBUTEINT:
        return fieldattributeint != FIELDATTRIBUTEINT_EDEFAULT;
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
    result.append(" (fieldattribute: ");
    result.append(fieldattribute);
    result.append(", fieldattributestring: ");
    result.append(fieldattributestring);
    result.append(", fieldattributeint: ");
    result.append(fieldattributeint);
    result.append(')');
    return result.toString();
  }

} //FieldattributeImpl
