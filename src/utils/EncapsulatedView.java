/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.dooapp.fxform.FXForm;
import daos.AbstractDao;
import daos.TireBrandDao;
import entities.TireBrand;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author leonardo
 */
public class EncapsulatedView<E> {

    //private Class<E> entityClass;
    private AnchorPane apForm;
    private AnchorPane apTableView;

    private E entity;
    private AbstractDao dao;

    private TableView tableView;
    private FXForm<E> form;

    private String includes[];

    public EncapsulatedView(EncapsulatedViewBuilder EncapViewBuilder) throws IllegalAccessException, InstantiationException {
        this.apForm = EncapViewBuilder.apForm;
        this.apTableView = EncapViewBuilder.apTableView;
        this.dao = EncapViewBuilder.dao;
        this.entity = (E) EncapViewBuilder.entityClass.newInstance();
        this.includes = EncapViewBuilder.includes;
    }

    /*public Class<E> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<E> entityClass) {
        this.entityClass = entityClass;
    }*/
    public AnchorPane getApForm() {
        return apForm;
    }

    public void setApForm(AnchorPane apForm) {
        this.apForm = apForm;
    }

    public AnchorPane getApTableView() {
        return apTableView;
    }

    public void setApTableView(AnchorPane apTableView) {
        this.apTableView = apTableView;
    }

    public E getEntity() {
        return entity;
    }

    public void setEntity(E entity) {
        this.entity = entity;
    }

    public AbstractDao getDao() {
        return dao;
    }

    public void setDao(AbstractDao dao) {
        this.dao = dao;
    }

    public TableView getTableView() {
        return tableView;
    }

    public void setTableView(TableView tableView) {
        this.tableView = tableView;
    }

    public FXForm<E> getForm() {
        return form;
    }

    public void setForm(FXForm<E> form) {
        this.form = form;
    }

    public String[] getIncludes() {
        return includes;
    }

    public void setIncludes(String[] includes) {
        this.includes = includes;
    }

    public static class EncapsulatedViewBuilder<E> {

        //private Class<E> entityClass;
        private AnchorPane apForm;
        private AnchorPane apTableView;
        private Class<E> entityClass;
        private AbstractDao dao;
        private String includes[];

        private EncapsulatedViewBuilder() {
        }

        static public <E> EncapsulatedViewBuilder<E> start() {
            return new EncapsulatedViewBuilder<>();
        }

        public EncapsulatedViewBuilder apForm(AnchorPane apForm) {
            this.apForm = apForm;
            return this;
        }

        public EncapsulatedViewBuilder apTableView(AnchorPane apTableView) {
            this.apTableView = apTableView;
            return this;
        }

        public EncapsulatedViewBuilder entityClass(Class<E> entityClass) {
            this.entityClass = entityClass;
            return this;
        }

        public EncapsulatedViewBuilder dao(AbstractDao dao) {
            this.dao = dao;
            return this;
        }

        public EncapsulatedViewBuilder includes(String[] includes) {
            this.includes = includes;
            return this;
        }

        public EncapsulatedView<E> build() throws IllegalAccessException, InstantiationException {
            return new EncapsulatedView<>(this);
        }
    }
}
