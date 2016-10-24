/**
 */
package benchmarkdp.datagenerator.model.PSMLibre.impl;

import benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage;
import benchmarkdp.datagenerator.model.PSMLibre.Text;
import benchmarkdp.datagenerator.model.PSMLibre.TextContainer;

import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Text Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.impl.TextContainerImpl#getWords <em>Words</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TextContainerImpl extends ElementImpl implements TextContainer {
	/**
	 * The cached value of the '{@link #getWords() <em>Words</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWords()
	 * @generated
	 * @ordered
	 */
	protected EList<Text> words;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TextContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PSMLibrePackage.Literals.TEXT_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Text> getWords() {
		if (words == null) {
			words = new EObjectResolvingEList<Text>(Text.class, this, PSMLibrePackage.TEXT_CONTAINER__WORDS);
		}
		return words;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PSMLibrePackage.TEXT_CONTAINER__WORDS:
				return getWords();
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
			case PSMLibrePackage.TEXT_CONTAINER__WORDS:
				getWords().clear();
				getWords().addAll((Collection<? extends Text>)newValue);
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
			case PSMLibrePackage.TEXT_CONTAINER__WORDS:
				getWords().clear();
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
			case PSMLibrePackage.TEXT_CONTAINER__WORDS:
				return words != null && !words.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TextContainerImpl
