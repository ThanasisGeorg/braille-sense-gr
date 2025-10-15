package com.thanasis.braillesensegr.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.thanasis.braillesensegr.R

@Composable
fun MenuTitle() {
    Text(
        "",
        fontSize = 34.sp,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun HomeItem(navHostController: NavHostController) {
    NavigationDrawerItem(
        label = { Text("") },
        selected = false,
        onClick = {  },
        icon = { Icon(Icons.Filled.Home, contentDescription = "Home") }
    )
}

@Composable
fun SearchItem(navHostController: NavHostController) {
    NavigationDrawerItem(
        label = { Text("") },
        selected = false,
        onClick = {  },
        icon = { Icon(Icons.Filled.Search, contentDescription = "Search") }
    )
}

@Composable
fun SettingsItem(navHostController: NavHostController) {
    NavigationDrawerItem(
        label = { Text("") },
        selected = false,
        onClick = {  },
        icon = { Icon(Icons.Filled.Settings, contentDescription = "Settings") }
    )
}

/*
@Composable
fun MenuDrawer(
    navHostController: NavHostController,
    selectedIndex: String
) {
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                MenuTitle()
                HorizontalDivider(thickness = 2.dp)
                HomeItem(navHostController)
                SearchItem(navHostController)
                SettingsItem(navHostController)
            }
        }
    ) {
        when (selectedIndex) {
            "home" -> {
                HomeInit(navHostController, stringResource(id = R.string.home))
            }
            "search" -> {
                SearchInit(navHostController, stringResource(id = R.string.search), userLoggedIn, notificationService)
            }
            "settings" -> {
                SettingsInit(navHostController, stringResource(id = R.string.settings), roomDb, userLoggedIn)
            }
            "profile" -> {
                ProfileInit(navHostController, stringResource(id = R.string.profile), userLoggedIn, roomDb, notificationService)
            }
            "editInfo" -> {
                EditInfoInit(navHostController, stringResource(id = R.string.edit_info), db, userLoggedIn)
            }
            "add_bike" -> {
                AddBikeInit(navHostController, stringResource(id = R.string.add_bike), db, userLoggedIn, notificationService)
            }
            "my_bike_list" -> {
                MyBikeListInit(navHostController, stringResource(id = R.string.bike_list), userLoggedIn, notificationService)
            }
            "available_bikes" -> {
                AvailableBikeListInit(navHostController, stringResource(id = R.string.available_bikes), userLoggedIn, notificationService)
            }
        }
    }
}
*/