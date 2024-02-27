/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.deviceinfo.firmwareversion;

import android.app.settings.SettingsEnums;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.settings.R;
import com.android.settings.dashboard.DashboardFragment;
import com.android.settings.search.BaseSearchIndexProvider;
import com.android.settingslib.search.SearchIndexable;

@SearchIndexable
public class FirmwareVersionSettings extends DashboardFragment {

    @Override
    protected int getPreferenceScreenResId() {
        return R.xml.firmware_version;
    }
    
    @Override
	public RecyclerView onCreateRecyclerView(LayoutInflater inflater, ViewGroup container, Bundle icicle) {
		RecyclerView recyclerView = super.onCreateRecyclerView(inflater, container, icicle);
		GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
		layoutManager.setSpanSizeLookup(new SpanSizeLookup());
		recyclerView.setLayoutManager(layoutManager);
		return recyclerView;
	}
	
	class SpanSizeLookup extends GridLayoutManager.SpanSizeLookup {
		@Override
		public int getSpanSize(int position) {
		    if (position == 1 || position == 2) {
				return 1;
			} else {
				return 2;
			}
		}
	}

    @Override
    protected String getLogTag() {
        return "FirmwareVersionSettings";
    }

    @Override
    public int getMetricsCategory() {
        return SettingsEnums.DIALOG_FIRMWARE_VERSION;
    }

    public static final BaseSearchIndexProvider SEARCH_INDEX_DATA_PROVIDER =
            new BaseSearchIndexProvider(R.xml.firmware_version);
}
