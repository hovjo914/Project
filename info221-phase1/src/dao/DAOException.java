package dao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author johnl_000
 */
public class DAOException extends RuntimeException {

    /**
     * Creates a new instance of
     * <code>DAOException</code> without detail message.
     */
    public DAOException(String msg) {
        super(msg);
    }

    /**
     * Constructs an instance of
     * <code>DAOException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public DAOException(String msg, Exception ex) {
        super(msg);

    }
}
