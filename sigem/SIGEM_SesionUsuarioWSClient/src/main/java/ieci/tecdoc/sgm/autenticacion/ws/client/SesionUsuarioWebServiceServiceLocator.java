/**
 * SesionUsuarioWebServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package ieci.tecdoc.sgm.autenticacion.ws.client;

public class SesionUsuarioWebServiceServiceLocator extends org.apache.axis.client.Service implements ieci.tecdoc.sgm.autenticacion.ws.client.SesionUsuarioWebServiceService {

    public SesionUsuarioWebServiceServiceLocator() {
    }


    public SesionUsuarioWebServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SesionUsuarioWebServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SesionUsuarioWebService
    private java.lang.String SesionUsuarioWebService_address = "http://localhost:8080/SIGEM_SessionUsuarioWS/services/SesionUsuarioWebService";

    public java.lang.String getSesionUsuarioWebServiceAddress() {
        return SesionUsuarioWebService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SesionUsuarioWebServiceWSDDServiceName = "SesionUsuarioWebService";

    public java.lang.String getSesionUsuarioWebServiceWSDDServiceName() {
        return SesionUsuarioWebServiceWSDDServiceName;
    }

    public void setSesionUsuarioWebServiceWSDDServiceName(java.lang.String name) {
        SesionUsuarioWebServiceWSDDServiceName = name;
    }

    public ieci.tecdoc.sgm.autenticacion.ws.client.SesionUsuarioWebService getSesionUsuarioWebService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SesionUsuarioWebService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSesionUsuarioWebService(endpoint);
    }

    public ieci.tecdoc.sgm.autenticacion.ws.client.SesionUsuarioWebService getSesionUsuarioWebService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ieci.tecdoc.sgm.autenticacion.ws.client.SesionUsuarioWebServiceSoapBindingStub _stub = new ieci.tecdoc.sgm.autenticacion.ws.client.SesionUsuarioWebServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getSesionUsuarioWebServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSesionUsuarioWebServiceEndpointAddress(java.lang.String address) {
        SesionUsuarioWebService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ieci.tecdoc.sgm.autenticacion.ws.client.SesionUsuarioWebService.class.isAssignableFrom(serviceEndpointInterface)) {
                ieci.tecdoc.sgm.autenticacion.ws.client.SesionUsuarioWebServiceSoapBindingStub _stub = new ieci.tecdoc.sgm.autenticacion.ws.client.SesionUsuarioWebServiceSoapBindingStub(new java.net.URL(SesionUsuarioWebService_address), this);
                _stub.setPortName(getSesionUsuarioWebServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SesionUsuarioWebService".equals(inputPortName)) {
            return getSesionUsuarioWebService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://server.ws.autenticacion.sgm.tecdoc.ieci", "SesionUsuarioWebServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://server.ws.autenticacion.sgm.tecdoc.ieci", "SesionUsuarioWebService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SesionUsuarioWebService".equals(portName)) {
            setSesionUsuarioWebServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
