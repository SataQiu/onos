package org.onlab.onos.openflow.controller;

import org.onlab.packet.Ethernet;
import org.projectfloodlight.openflow.types.OFPort;

/**
 * A representation of a packet context which allows any provider
 * to view a packet in event, but may block the response to the
 * event if blocked has been called. This packet context can be used
 * to react to the packet in event with a packet out.
 */
public interface OpenFlowPacketContext {

    //TODO: may want to support sending packet out other switches than
    // the one it came in on.
    /**
     * Blocks further responses (ie. send() calls) on this
     * packet in event.
     */
    public boolean block();

    /**
     * Checks whether the packet has been handled.
     * @return true if handled, false otherwise.
     */
    public boolean isHandled();

    /**
     * Provided build has been called send the packet
     * out the switch it came in on.
     */
    public void send();

    /**
     * Build the packet out in response to this packet in event.
     * @param outPort the out port to send to packet out of.
     */
    public void build(OFPort outPort);

    /**
     * Build the packet out in response to this packet in event.
     * @param ethFrame the actual packet to send out.
     * @param outPort the out port to send to packet out of.
     */
    public void build(Ethernet ethFrame, OFPort outPort);

    /**
     * Provided a handle onto the parsed payload.
     * @return the parsed form of the payload.
     */
    public Ethernet parsed();

    /**
     * Provide an unparsed copy of the data.
     * @return the unparsed form of the payload.
     */
    public byte[] unparsed();

    /**
     * Provide the dpid of the switch where the packet in arrived.
     * @return the dpid of the switch.
     */
    public Dpid dpid();

    /**
     * Provide the port on which the packet arrived.
     * @return the port
     */
    public Integer inPort();

    /**
     * Indicates that this packet is buffered at the switch.
     * @return buffer indication
     */
    boolean isBuffered();
}