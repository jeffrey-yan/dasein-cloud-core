package org.dasein.cloud.compute;

import org.dasein.cloud.Capabilities;
import org.dasein.cloud.CloudException;
import org.dasein.cloud.InternalException;

import javax.annotation.Nonnull;
import java.util.Locale;

/**
 * Describes the capabilities of an Affinity Group within a cloud
 * Created by Drew Lyall: 11/07/14 11:50
 * @author Drew Lyall
 * @version 2014.07
 * @since 2014.07
 */
public interface AffinityGroupCapabilities extends Capabilities{
    /**
     * Indicates whether affinity groups can be created in the underlying cloud
     * @return true if affinity groups can be created
     */
    public boolean canCreate();

    /**
     * Indicates whether affinity groups can be deleted from the underlying cloud
     * @return true if affinity groups can be deleted
     */
    public boolean canDelete();

    /**
     * Indicates whether affinity groups can be altered in the underlying cloud
     * @return true if the cloud allows modification to the affinity group
     */
    public boolean canModify();

    /**
     * Indicates the maximum number of affinity groups that can be specified in a region.
     * @return the maximum number of groups that may be provisioned, -1 for unlimited or -2 for unknown
     * @throws InternalException an error occurred within the Dasein Cloud implementation determining the limit
     * @throws CloudException an error occurred retrieving the limit from the cloud
     */
    public int getMaximumAffinityGroupCount() throws InternalException, CloudException;

    /**
     * Indicates the maximum number of VMs that can be provisioned within the specified affinity group
     * @return the maximum number of VMs that may be provisioned, -1 for unlimited or -2 for unknown
     * @throws InternalException an error occurred within the Dasein Cloud implementation determining the limit
     * @throws CloudException an error occurred retrieving the limit from the cloud
     */
    public int getMaximumVMCount() throws InternalException, CloudException;

    /**
     * Specifies the provider term for an Affinity Group
     * @param locale the locale into which the term should be translated
     * @return the provider term for affinity groups
     */
    public String getProviderTermForAffinityGroup(@Nonnull Locale locale);

    /**
     * Indicates whether the cloud supports the idea of anti-affinity if resources are placed in separate groups
     * @return true indicating the cloud does support anti-affinity
     * @throws InternalException and error occurred within the Dasein Cloud implementation determining anti-affinity support
     * @throws CloudException an error occurred retrieving the value from the cloud
     */
    public boolean supportsAntiAffinity() throws InternalException, CloudException;
}