/**
 */
package benchmarkdp.datagenerator.model.PIM;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link benchmarkdp.datagenerator.model.PIM.Document#getName <em>Name</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PIM.Document#getAuthor <em>Author</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PIM.Document#getPages <em>Pages</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PIM.Document#getDocumentBackground <em>Document Background</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PIM.Document#isCalcLayout <em>Calc Layout</em>}</li>
 * </ul>
 *
 * @see benchmarkdp.datagenerator.model.PIM.PIMPackage#getDocument()
 * @model
 * @generated
 */
public interface Document extends EObject {
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
	 * @see benchmarkdp.datagenerator.model.PIM.PIMPackage#getDocument_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PIM.Document#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Author</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Author</em>' attribute.
	 * @see #setAuthor(String)
	 * @see benchmarkdp.datagenerator.model.PIM.PIMPackage#getDocument_Author()
	 * @model
	 * @generated
	 */
	String getAuthor();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PIM.Document#getAuthor <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Author</em>' attribute.
	 * @see #getAuthor()
	 * @generated
	 */
	void setAuthor(String value);

	/**
	 * Returns the value of the '<em><b>Pages</b></em>' containment reference list.
	 * The list contents are of type {@link benchmarkdp.datagenerator.model.PIM.Page}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pages</em>' containment reference list.
	 * @see benchmarkdp.datagenerator.model.PIM.PIMPackage#getDocument_Pages()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Page> getPages();

	/**
	 * Returns the value of the '<em><b>Document Background</b></em>' attribute.
	 * The default value is <code>"WHITE"</code>.
	 * The literals are from the enumeration {@link benchmarkdp.datagenerator.model.PIM.Color}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Document Background</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Document Background</em>' attribute.
	 * @see benchmarkdp.datagenerator.model.PIM.Color
	 * @see #setDocumentBackground(Color)
	 * @see benchmarkdp.datagenerator.model.PIM.PIMPackage#getDocument_DocumentBackground()
	 * @model default="WHITE"
	 * @generated
	 */
	Color getDocumentBackground();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PIM.Document#getDocumentBackground <em>Document Background</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Document Background</em>' attribute.
	 * @see benchmarkdp.datagenerator.model.PIM.Color
	 * @see #getDocumentBackground()
	 * @generated
	 */
	void setDocumentBackground(Color value);

	/**
	 * Returns the value of the '<em><b>Calc Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Calc Layout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Calc Layout</em>' attribute.
	 * @see #setCalcLayout(boolean)
	 * @see benchmarkdp.datagenerator.model.PIM.PIMPackage#getDocument_CalcLayout()
	 * @model
	 * @generated
	 */
	boolean isCalcLayout();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PIM.Document#isCalcLayout <em>Calc Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Calc Layout</em>' attribute.
	 * @see #isCalcLayout()
	 * @generated
	 */
	void setCalcLayout(boolean value);

} // Document
