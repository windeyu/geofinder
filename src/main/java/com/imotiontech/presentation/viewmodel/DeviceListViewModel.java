package com.imotiontech.presentation.viewmodel;

import com.imotiontech.domain.Account;
import com.imotiontech.domain.Device;
import com.imotiontech.domain.Location;
import com.imotiontech.repository.AccountRepository;
import com.imotiontech.repository.LocationRepository;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class DeviceListViewModel {

    private boolean isHistoryVisible;  // is the history view visible?
    private Device selectedDevice; // for history


    //wire spring beans
    @WireVariable("accountRepository")
    AccountRepository accountRepository;
    @WireVariable("locationRepository")
    LocationRepository locationRepository;

    public List<Device> getDeviceList() {
        String accountName = (String) Executions.getCurrent().getSession().getAttribute("accountName");
        if (accountName != null) {
            Optional<Account> account = accountRepository.findByName(accountName);
            if (account.isPresent()) {
                return account.get().getDevices();
            }
        }
        return Collections.emptyList();
    }

    /**
     * Get the location history of the selected device
     * @return
     */
    public List<Location> getHistoryList() {
        if (selectedDevice != null) {
            return locationRepository.findByDeviceName(selectedDevice.getName()); // get latest from db
        }
        return null;
    }

    /**
     * Get the selected device (for history display)
     * @return
     */
    public Device getSelectedDevice() {
        return selectedDevice;
    }

    /**
     * Is the history view visible?  Invoked by home.zul, name has to match
     * @return
     */
    public boolean getIsHistoryVisible() {
        return isHistoryVisible;
    }

    public String getHistoryTitle() {
        String title = "[X] History";
        if (selectedDevice != null) {
            title = title + " of " + selectedDevice.getName();
        }
        return title;
    }

    /**
     * Show history given a device
     *
     * @param device
     */
    @Command
    @NotifyChange({"isHistoryVisible", "historyTitle", "historyList"})
    public void showHistory(@BindingParam("device") Device device) {
        selectedDevice = device;
        isHistoryVisible = true;
    }

    /**
     * Close the device history view
     */
    @Command
    @NotifyChange("isHistoryVisible")
    public void closeHistory() {
        isHistoryVisible = false;
    }
}
