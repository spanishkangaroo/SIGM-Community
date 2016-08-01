/**
 * FacturaWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.dipucr.factura.services.factura;

public interface FacturaWS extends java.rmi.Remote {
    public void cambiarEstadoFactura(java.lang.String idEntidad, java.lang.String nreg, java.lang.String codEstado, int subtipo, java.lang.String motivo) throws java.rmi.RemoteException;
    public void cambiarEstadoAnulacionFactura(java.lang.String idEntidad, java.lang.String nreg, java.lang.String codEstado, java.lang.String motivo) throws java.rmi.RemoteException;
    public void enviarFacturaFirmada(java.lang.String idEntidad, java.lang.String nreg, byte[] data) throws java.rmi.RemoteException;
    public es.dipucr.factura.domain.bean.ContratoMenorBean[] recuperarContratosMenores(java.lang.String idEntidad, java.lang.String ejercicio, java.util.Calendar dFechaInicio, java.util.Calendar dFechaFin, java.lang.String sImporteDesde, java.lang.String sImporteHasta, java.lang.String[] arrPartidasExluidas) throws java.rmi.RemoteException;
}