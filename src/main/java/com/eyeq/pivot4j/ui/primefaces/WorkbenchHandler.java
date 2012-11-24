package com.eyeq.pivot4j.ui.primefaces;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.extensions.model.layout.LayoutOptions;

import com.eyeq.pivot4j.PivotModel;

@ManagedBean
@RequestScoped
public class WorkbenchHandler {

	@ManagedProperty(value = "#{pivotModelManager.model}")
	private PivotModel model;

	private boolean editorPaneVisible = false;

	private boolean navigatorPaneVisible = true;

	private LayoutOptions layoutOptions;

	/**
	 * @return the model
	 */
	public PivotModel getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(PivotModel model) {
		this.model = model;
	}

	/**
	 * @return the layoutOptions
	 */
	public LayoutOptions getLayoutOptions() {
		if (layoutOptions == null) {
			this.layoutOptions = new LayoutOptions();

			LayoutOptions toolbarOptions = new LayoutOptions();
			toolbarOptions.addOption("resizable", false);
			toolbarOptions.addOption("closable", false);
			toolbarOptions.addOption("size", 42);

			layoutOptions.setNorthOptions(toolbarOptions);

			LayoutOptions navigatorOptions = new LayoutOptions();
			navigatorOptions.addOption("resizable", true);
			navigatorOptions.addOption("closable", true);
			navigatorOptions.addOption("slidable", true);
			navigatorOptions.addOption("size", 280);

			layoutOptions.setWestOptions(navigatorOptions);

			LayoutOptions childWestOptions = new LayoutOptions();
			navigatorOptions.setChildOptions(childWestOptions);

			LayoutOptions targetTreeOptions = new LayoutOptions();
			targetTreeOptions.addOption("resizable", true);
			targetTreeOptions.addOption("closable", true);
			targetTreeOptions.addOption("slidable", true);
			targetTreeOptions.addOption("size", 300);

			childWestOptions.setSouthOptions(targetTreeOptions);

			LayoutOptions contentOptions = new LayoutOptions();
			layoutOptions.setCenterOptions(contentOptions);

			LayoutOptions childCenterOptions = new LayoutOptions();
			contentOptions.setChildOptions(childCenterOptions);

			LayoutOptions editorOptions = new LayoutOptions();
			editorOptions.addOption("resizable", true);
			editorOptions.addOption("closable", true);
			editorOptions.addOption("slidable", true);
			editorOptions.addOption("size", 180);
			editorOptions.addOption("contentSelector", "CodeMirror-scroll");

			childCenterOptions.setSouthOptions(editorOptions);
		}

		return layoutOptions;
	}

	/**
	 * @return the editorPaneVisible
	 */
	public boolean isEditorPaneVisible() {
		return editorPaneVisible;
	}

	/**
	 * @param editorPaneVisible
	 *            the editorPaneVisible to set
	 */
	public void setEditorPaneVisible(boolean editorPaneVisible) {
		this.editorPaneVisible = editorPaneVisible;
	}

	/**
	 * @return the navigatorPaneVisible
	 */
	public boolean isNavigatorPaneVisible() {
		return navigatorPaneVisible;
	}

	/**
	 * @param navigatorPaneVisible
	 *            the navigatorPaneVisible to set
	 */
	public void setNavigatorPaneVisible(boolean navigatorPaneVisible) {
		this.navigatorPaneVisible = navigatorPaneVisible;
	}
}