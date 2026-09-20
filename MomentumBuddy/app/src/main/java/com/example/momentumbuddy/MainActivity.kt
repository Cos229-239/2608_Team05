package com.example.momentumbuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.momentumbuddy.ui.theme.MomentumBuddyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MomentumBuddyTheme  {
            var showLogin by remember { mutableStateOf(false) }
            if (showLogin){ LoginScreen() }
            else {
                MomentumBuddySplash(
                    onGetStartedClick = { showLogin = true })
                }
            }
        }
    }
}
private val Coral = Color(0xFFFF8D7A)
private val LightCoral = Color(0xFFFFD7D0)
private val Peach = Color(0xFFFFF5F0)
private val Navy = Color(0xFF16345B)

@Composable
fun MomentumBuddySplash(onGetStartedClick: () -> Unit) {
    Surface(modifier = Modifier.fillMaxSize(), color = Peach)
    {
        Column(
            modifier = Modifier.fillMaxSize().padding(28.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Box(
                modifier = Modifier.size(125.dp).clip(CircleShape).background(LightCoral),
                contentAlignment = Alignment.Center
            )
            {
                Text(
                    text = " ",
                    color = Coral,
                    fontSize = 56.sp
                )
            }
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Momentum\nBuddy",
                color = Navy,
                fontSize = 38.sp,
                lineHeight = 42.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Text(
                text = "G U I D E",
                color = Coral,
                fontWeight = FontWeight.Bold,
                letterSpacing = 4.sp
            )

            Spacer(modifier = Modifier.height(56.dp))

            Button(
                onClick = onGetStartedClick,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Coral,
                    contentColor = Color.White))
            {
                Text("GET STARTED")
            }

        }
    }

}

@Composable
fun LoginScreen(){
    Surface( modifier = Modifier.fillMaxSize(), color = Peach)
    { Column( modifier = Modifier.fillMaxSize() .padding(28.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    { Text( text = "Welcome back!", color = Navy, fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(12.dp))

        Text( text = "Log in to continue your journey", color = Color.Gray,
            textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Coral),
            shape = RoundedCornerShape(12.dp))
        { Text("LOG IN") }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Login form coming next",
            color = Navy,
            fontSize = 14.sp)
        }
    }
}
