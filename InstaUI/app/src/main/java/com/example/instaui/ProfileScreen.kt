package com.example.instaui

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instaui.ui.theme.Montserrat

@Composable
fun ProfileScreen(){
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    Column(modifier = Modifier
        .fillMaxSize()) {
        TopBar(name = "aryanprasher_")
        Spacer(modifier = Modifier.height(25.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(25.dp))
        HighlightSection(
            highlights = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.maclodp),
                    text = "Maclo"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.meetdp),
                    text = "Meet"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.collagedp),
                    text = "Me"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.newalbum),
                    text = "New"
                )
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        PostTabView(
            imageWithText = listOf(
                ImageWithText(
                    painterResource(id = R.drawable.ic_grid),
                    text = "Posts"
                ),
                ImageWithText(
                    painterResource(id = R.drawable.ic_reels),
                    text = "Reels"
                ),
                ImageWithText(
                    painterResource(id = R.drawable.taggedicon),
                    text = "TaggedPosts"
                )
            ),

        ){
            selectedTabIndex = it
        }
        when(selectedTabIndex){
            0 -> PostSection(
                posts = listOf(
                    painterResource(id = R.drawable.post1),
                    painterResource(id = R.drawable.post2),
                    painterResource(id = R.drawable.post3),
                    painterResource(id = R.drawable.post4),
                    painterResource(id = R.drawable.postlast),
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun TopBar(
    name : String,
    modifier: Modifier = Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 20.dp, end = 20.dp)

    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.Black,
                modifier = Modifier.size(27.dp)
            )
            Spacer(modifier = modifier.width(15.dp))
            Text(
                text = name,
                overflow = TextOverflow.Ellipsis,
                //adds three dots after if name is too big
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
//            Icon(
//                imageVector = Icons.Default.ArrowDropDown,
//                contentDescription = null,
//                tint = Color.Black,
//                modifier = Modifier.size(10.dp)
//            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.addpost),
                contentDescription = "AddPost",
                tint = Color.Black,
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = modifier.width(20.dp))
            Icon(
                painter = painterResource(id = R.drawable.option),
                contentDescription = "Back",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
        }

    }
}


//the profile section
@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
){
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ){
            RoundImage(image = painterResource(id = R.drawable.instadp),
                    modifier = Modifier
                        .size(100.dp)
                        .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7f))
        }
        Spacer(modifier = Modifier.height(9.dp))
        ProfileDescription(
            displayName = "PRASHER",
            description = "Tatakae Tatakae\nStoic ?\nNIT-H CSE'25"
        )

        Spacer(modifier = Modifier.height(9.dp))

        EditProfile()

        Spacer(modifier = Modifier.height(9.dp))

    }
}

//dp part
@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
){
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
}

@Composable
fun StatSection(
    modifier: Modifier = Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStat(numberText = "5", text = "Posts")
        ProfileStat(numberText = "438", text = "Followers")
        ProfileStat(numberText = "267", text = "Following")
    }
}

@Composable
fun ProfileStat(
    numberText:String,
    text : String,
    modifier: Modifier = Modifier
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text
        )
    }
}

@Composable
fun ProfileDescription(
    displayName:String,
    description : String
){
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Medium,
            fontFamily = Montserrat,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
    }
}

@Composable
fun EditProfile(){

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    )
    {
        Card(
            modifier = Modifier
                .weight(10f)
                .height(30.dp)
                ,
            contentColor = Color.Black,
            shape = RoundedCornerShape(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Edit Profile",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.width(2.dp))

        Card(
            modifier = Modifier
                .weight(1f)
                .height(30.dp)
                ,
            contentColor = Color.Black,
            shape = RoundedCornerShape(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.addfriend),
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
fun  HighlightSection(
    modifier :Modifier = Modifier,
    highlights: List<ImageWithText>
){
    LazyRow(modifier = modifier){
        items(highlights.size){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(end=15.dp)
            ) {
                RoundImage(
                    image = highlights[it].image,
                    modifier = Modifier.size(70.dp)
                )
                Text(
                    text = highlights[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithText: List<ImageWithText>,
    onTabSelected : (selectedIndex : Int) -> Unit
){
    var selectedTabIndex by remember{
        mutableStateOf(0)
    }
    var inactiveColor = Color(0xFF777777)

    TabRow(selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        imageWithText.forEachIndexed { index, item ->
            Tab(
                selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }
            ) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if(selectedTabIndex == index)    Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostSection(
    posts : List<Painter>,
    modifier : Modifier = Modifier
){
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = Modifier.scale(1.01f)
    ){
        items(posts.size){
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }
}