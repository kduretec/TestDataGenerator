/**
 */
package benchmarkdp.datagenerator.model.PSMLibre;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.Element#getID <em>ID</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.Element#getParentID <em>Parent ID</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.Element#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.Element#getAlignment <em>Alignment</em>}</li>
 * </ul>
 *
 * @see benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage#getElement()
 * @model abstract="true"
 * @generated
 */
public interface Element extends EObject {
	/**
	 * Returns the value of the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ID</em>' attribute.
	 * @see #setID(String)
	 * @see benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage#getElement_ID()
	 * @model
	 * @generated
	 */
	String getID();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PSMLibre.Element#getID <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ID</em>' attribute.
	 * @see #getID()
	 * @generated
	 */
	void setID(String value);

	/**
	 * Returns the value of the '<em><b>Parent ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent ID</em>' attribute.
	 * @see #setParentID(String)
	 * @see benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage#getElement_ParentID()
	 * @model
	 * @generated
	 */
	String getParentID();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PSMLibre.Element#getParentID <em>Parent ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent ID</em>' attribute.
	 * @see #getParentID()
	 * @generated
	 */
	void setParentID(String value);

	/**
	 * Returns the value of the '<em><b>Background Color</b></em>' attribute.
	 * The default value is <code>"WHITE"</code>.
	 * The literals are from the enumeration {@link benchmarkdp.datagenerator.model.PSMLibre.Color}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Background Color</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Background Color</em>' attribute.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Color
	 * @see #setBackgroundColor(Color)
	 * @see benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage#getElement_BackgroundColor()
	 * @model default="WHITE"
	 * @generated
	 */
	Color getBackgroundColor();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PSMLibre.Element#getBackgroundColor <em>Background Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Background Color</em>' attribute.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Color
	 * @see #getBackgroundColor()
	 * @generated
	 */
	void setBackgroundColor(Color value);

	/**
	 * Returns the value of the '<em><b>Alignment</b></em>' attribute.
	 * The default value is <code>"LEFT"</code>.
	 * The literals are from the enumeration {@link benchmarkdp.datagenerator.model.PSMLibre.Alignment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alignment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alignment</em>' attribute.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Alignment
	 * @see #setAlignment(Alignment)
	 * @see benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage#getElement_Alignment()
	 * @model default="LEFT"
	 * @generated
	 */
	Alignment getAlignment();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PSMLibre.Element#getAlignment <em>Alignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alignment</em>' attribute.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Alignment
	 * @see #getAlignment()
	 * @generated
	 */
	void setAlignment(Alignment value);

} // Element
