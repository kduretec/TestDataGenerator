/**
 */
package benchmarkdp.datagenerator.model.PIM.impl;

import benchmarkdp.datagenerator.model.PIM.Color;
import benchmarkdp.datagenerator.model.PIM.Document;
import benchmarkdp.datagenerator.model.PIM.PIMPackage;
import benchmarkdp.datagenerator.model.PIM.Page;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link benchmarkdp.datagenerator.model.PIM.impl.DocumentImpl#getName <em>Name</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PIM.impl.DocumentImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PIM.impl.DocumentImpl#getPages <em>Pages</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PIM.impl.DocumentImpl#getDocumentBackground <em>Document Background</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PIM.impl.DocumentImpl#isCalcLayout <em>Calc Layout</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DocumentImpl extends MinimalEObjectImpl.Container implements Document {
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
	 * The default value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTHOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected String author = AUTHOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPages() <em>Pages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPages()
	 * @generated
	 * @ordered
	 */
	protected EList<Page> pages;

	/**
	 * The default value of the '{@link #getDocumentBackground() <em>Document Background</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentBackground()
	 * @generated
	 * @ordered
	 */
	protected static final Color DOCUMENT_BACKGROUND_EDEFAULT = Color.WHITE;

	/**
	 * The cached value of the '{@link #getDocumentBackground() <em>Document Background</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentBackground()
	 * @generated
	 * @ordered
	 */
	protected Color documentBackground = DOCUMENT_BACKGROUND_EDEFAULT;

	/**
	 * The default value of the '{@link #isCalcLayout() <em>Calc Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCalcLayout()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CALC_LAYOUT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCalcLayout() <em>Calc Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCalcLayout()
	 * @generated
	 * @ordered
	 */
	protected boolean calcLayout = CALC_LAYOUT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PIMPackage.Literals.DOCUMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PIMPackage.DOCUMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthor(String newAuthor) {
		String oldAuthor = author;
		author = newAuthor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PIMPackage.DOCUMENT__AUTHOR, oldAuthor, author));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Page> getPages() {
		if (pages == null) {
			pages = new EObjectContainmentEList<Page>(Page.class, this, PIMPackage.DOCUMENT__PAGES);
		}
		return pages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color getDocumentBackground() {
		return documentBackground;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDocumentBackground(Color newDocumentBackground) {
		Color oldDocumentBackground = documentBackground;
		documentBackground = newDocumentBackground == null ? DOCUMENT_BACKGROUND_EDEFAULT : newDocumentBackground;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PIMPackage.DOCUMENT__DOCUMENT_BACKGROUND, oldDocumentBackground, documentBackground));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCalcLayout() {
		return calcLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCalcLayout(boolean newCalcLayout) {
		boolean oldCalcLayout = calcLayout;
		calcLayout = newCalcLayout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PIMPackage.DOCUMENT__CALC_LAYOUT, oldCalcLayout, calcLayout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PIMPackage.DOCUMENT__PAGES:
				return ((InternalEList<?>)getPages()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PIMPackage.DOCUMENT__NAME:
				return getName();
			case PIMPackage.DOCUMENT__AUTHOR:
				return getAuthor();
			case PIMPackage.DOCUMENT__PAGES:
				return getPages();
			case PIMPackage.DOCUMENT__DOCUMENT_BACKGROUND:
				return getDocumentBackground();
			case PIMPackage.DOCUMENT__CALC_LAYOUT:
				return isCalcLayout();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PIMPackage.DOCUMENT__NAME:
				setName((String)newValue);
				return;
			case PIMPackage.DOCUMENT__AUTHOR:
				setAuthor((String)newValue);
				return;
			case PIMPackage.DOCUMENT__PAGES:
				getPages().clear();
				getPages().addAll((Collection<? extends Page>)newValue);
				return;
			case PIMPackage.DOCUMENT__DOCUMENT_BACKGROUND:
				setDocumentBackground((Color)newValue);
				return;
			case PIMPackage.DOCUMENT__CALC_LAYOUT:
				setCalcLayout((Boolean)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case PIMPackage.DOCUMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PIMPackage.DOCUMENT__AUTHOR:
				setAuthor(AUTHOR_EDEFAULT);
				return;
			case PIMPackage.DOCUMENT__PAGES:
				getPages().clear();
				return;
			case PIMPackage.DOCUMENT__DOCUMENT_BACKGROUND:
				setDocumentBackground(DOCUMENT_BACKGROUND_EDEFAULT);
				return;
			case PIMPackage.DOCUMENT__CALC_LAYOUT:
				setCalcLayout(CALC_LAYOUT_EDEFAULT);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PIMPackage.DOCUMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PIMPackage.DOCUMENT__AUTHOR:
				return AUTHOR_EDEFAULT == null ? author != null : !AUTHOR_EDEFAULT.equals(author);
			case PIMPackage.DOCUMENT__PAGES:
				return pages != null && !pages.isEmpty();
			case PIMPackage.DOCUMENT__DOCUMENT_BACKGROUND:
				return documentBackground != DOCUMENT_BACKGROUND_EDEFAULT;
			case PIMPackage.DOCUMENT__CALC_LAYOUT:
				return calcLayout != CALC_LAYOUT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", author: ");
		result.append(author);
		result.append(", documentBackground: ");
		result.append(documentBackground);
		result.append(", calcLayout: ");
		result.append(calcLayout);
		result.append(')');
		return result.toString();
	}

} //DocumentImpl
